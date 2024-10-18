package mil.darpa.immortals.core.das.pql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;

import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class PQLContext {

	public PQLContext() {}
	
	public String createOrGetCollisionResistantName(String simpleName) {
		
		String result = null;
		
		if (variables.containsKey(simpleName)) {
			result = variables.get(simpleName);
		} else {
			result = createCollisionResistantName(simpleName);
		}
		
		return result;
	}
	
	public String createCollisionResistantName(String simpleName) {
		String collisionResistantName = "a" + UUID.randomUUID().toString().replaceAll("-", "");
		variables.put(simpleName, collisionResistantName);
		return variables.get(simpleName);
	}
	
	public String getCollisionResistantName(String simpleName) {
		return variables.get(simpleName);
	}
	
	public boolean containsCollisionResistantName(String simpleName) {
		return variables.containsKey(simpleName);
	}
	
	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}

	public void setCompilationUnit(CompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}
	
	public TypeSolver getTypeSolver() {
		return typeSolver;
	}
	
	public void setTypeSolver(TypeSolver typeSolver) {
		this.typeSolver = typeSolver;
	}
		
	public PQLExecutionResult getPqlExecutionResult() {
		return pqlExecutionResult;
	}

	public void setPqlExecutionResult(PQLExecutionResult pqlExecutionResult) {
		this.pqlExecutionResult = pqlExecutionResult;
	}

	public List<RootFragmentPatternMatch> getRootFragmentPatternMatches() {
		return rootFragmentPatternMatches;
	}

	public void setRootFragmentPatternMatches(List<RootFragmentPatternMatch> rootFragmentPatternMatches) {
		this.rootFragmentPatternMatches = rootFragmentPatternMatches;
		setCurrentRootFragmentPatternMatch(null);
	}

	public void addRootFragmentPatternMatch(RootFragmentPatternMatch rootFragmentPatternMatch) {
		this.rootFragmentPatternMatches.add(rootFragmentPatternMatch);
	}
	
	public String getCompilationUnitFileName() {
		
		String result = "";
		
		if (getCompilationUnit().getStorage().isPresent()) {
			result = getCompilationUnit().getStorage().get().getPath().toString();
		}
		
		return result;
	}
	
	/**
	 * Call between compilation units.
	 */
	public void reset() {
		variables.clear();
		rootFragmentPatternMatches.clear();
		pendingBindings.clear();
		setCurrentRootFragmentPatternMatch(null);
	}
	
	public void resetPendingBindings() {
		pendingBindings = new HashMap<>();
	}
	
	public Map<String, ContextValue> getPendingBindings() {
		return pendingBindings;
	}
	
	public RootFragmentPatternMatch getCurrentRootFragmentPatternMatch() {
		return currentRootFragmentPatternMatch;
	}

	public void setCurrentRootFragmentPatternMatch(RootFragmentPatternMatch currentRootFragmentPatternMatch) {
		this.currentRootFragmentPatternMatch = currentRootFragmentPatternMatch;
	}
	
	public String getBindingAsString(String key) {
		
		String result = null;
		
		if (this.getCurrentRootFragmentPatternMatch() != null) {
			result = this.getCurrentRootFragmentPatternMatch().getBinding(key).getValue();
		}
		
		return result;
	}

	public String getBindingAsString(String key, int index) {
		
		String result = null;
		
		if (this.getCurrentRootFragmentPatternMatch() != null) {
			result = this.getCurrentRootFragmentPatternMatch().getBinding(key).getValueArray()[index];
		}
		
		return result;
	}

	private Map<String, String> variables = new HashMap<String, String>();
	private CompilationUnit compilationUnit;
	private TypeSolver typeSolver;
	private PQLExecutionResult pqlExecutionResult = null;
	private List<RootFragmentPatternMatch> rootFragmentPatternMatches = new ArrayList<RootFragmentPatternMatch>();
	//The pending bindings are provided to code artifact patterns as a way to bind code artifacts (pattern results) to names (which are provided
	//by user of PQL). When all conditions for a root fragment pattern are satisfied, the pending bindings are copied to an instance
	//of RootFragmentPatternMatch
	private Map<String, ContextValue> pendingBindings = new HashMap<>();
	private RootFragmentPatternMatch currentRootFragmentPatternMatch;

}
