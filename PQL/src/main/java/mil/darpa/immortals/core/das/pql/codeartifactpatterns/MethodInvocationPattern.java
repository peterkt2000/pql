package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.List;
import java.util.Optional;
import com.github.javaparser.Position;
import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodInvocation;
import mil.darpa.immortals.core.das.pql.selectors.MethodInvocationSelector;

public class MethodInvocationPattern extends AbstractCodeArtifactPattern<JavaMethodInvocation> {

	public MethodInvocationPattern(String id, Optional<String> receiverType, 
			Optional<String> methodName, 
			Optional<PatternContext> patternContext, 
			Optional<List<String>> argumentTypes) {
		
		this.id = id;
		this.receiverType = receiverType;
		this.methodName = methodName;
		this.patternContext = patternContext;
		this.argumentTypes = argumentTypes;
	}

	@Override
	public Optional<JavaMethodInvocation> match(PQLContext context, Optional<Position> after, 
			final Optional<CodeArtifact> parentCodeArtifact) {
		
		Optional<JavaMethodInvocation> result = Optional.empty();
		
		MethodInvocationSelector mis = new MethodInvocationSelector();
		mis.setMethodName(methodName);
		mis.setArgumentTypes(this.argumentTypes);
		mis.setReceiverType(this.receiverType);
		mis.setPatternContext(this.patternContext);

		Optional<JavaMethodInvocation> jmi = Optional.empty();

		switch (this.duplicatePolicy) {
			case HaltOnDuplicate:
				jmi = mis.select(context, after, parentCodeArtifact);
				if (jmi.isPresent() && this.matchesContain(jmi.get())) {
					jmi = Optional.empty();
				}
				break;
			case SearchNextUnique:
				if (this.getMatches().isPresent() && this.getMatches().get().size() > 0) {
					after = Optional.of(this.getMatches().get().get(this.getMatches().get().size()-1).getEndPosition());					
				}
				jmi = mis.select(context, after, parentCodeArtifact);
				break;
			case AllowDuplicate:
				jmi = mis.select(context, after, parentCodeArtifact);
				break;
			case CycleChildren:
			default:
				//Unsupported options for this pattern; should not occur if parser does its job
				throw new RuntimeException("Unsupported duplicate policy for code pattern: " + this.getClass().getName());
		}

		if (!jmi.isPresent()) {
			return result;
		}

		//At this point we have a result that satisfies the duplicate policy

		//Add this match to the prior matches list
		this.addMatch(jmi.get());

		//Bind the match to its id so it can be used
		if (id != null) {
			context.getPendingBindings().put(id, 
				new ContextValue(ContextValueType.CodeArtifact, jmi.get()));
		}

		result = jmi;

		this.processed = true;

		return result;
	}
	
	public Optional<String> getReceiverType() {
		return receiverType;
	}

	public Optional<String> getMethodName() {
		return methodName;
	}

	public Optional<PatternContext> getPatternContext() {
		return patternContext;
	}

	public Optional<List<String>> getArgumentTypes() {
		return argumentTypes;
	}

	private String id;
	private Optional<String> receiverType;
	private Optional<String> methodName;
	private Optional<PatternContext> patternContext;
	private Optional<List<String>> argumentTypes;
}
