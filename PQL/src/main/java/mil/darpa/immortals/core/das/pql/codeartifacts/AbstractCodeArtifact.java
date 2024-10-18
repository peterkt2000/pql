package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.Statement;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;

public abstract class AbstractCodeArtifact implements CodeArtifact {

	public AbstractCodeArtifact(PQLContext context) {
		if (context != null) {
			this.compilationUnit = context.getCompilationUnit();
		}
	}

	@Override
	public CompilationUnit getCompilationUnit() {
		return this.compilationUnit;
	}

	@Override
	public abstract Position getStartPosition();
	
	@Override
	public abstract Position getEndPosition();
	
	@Override
	public abstract String getSourceText();
	
	@Override
	public abstract JavaClass getAncestorClass();
	
	@Override
	public abstract void setAncestorClass(JavaClass javaClass);
	
	@Override
	public abstract Optional<Node> getSourceNode();

	@Override
	public Optional<PatternContext> getPatternContext() {
		return patternContext;
	}

	@Override
	public void setPatternContext(PatternContext patternContext) {
		this.patternContext = Optional.of(patternContext);
	}

	@Override
	public Optional<Statement> getContainingStatement() {
		
		Optional<Statement> result = Optional.empty();
		
		if (getSourceNode().isPresent()) {
			if (getSourceNode().get() instanceof Statement) {
				result = Optional.of((Statement) getSourceNode().get());
			} else {
				//ForUpgrade
				//result = getSourceNode().get().getAncestorOfType(Statement.class);
				result = getSourceNode().get().findAncestor(Statement.class);
			}
		}
		
		return result;
	}
	
	@Override
	public Optional<CodeArtifact> getParentCodeArtifact() {
		return parentCodeArtifact;
	}

	@Override
	public Optional<List<CodeArtifact>> getChildCodeArtifacts() {
		return childCodeArtifacts;
	}
	
	@Override
	public void setParentCodeArtifact(CodeArtifact codeArtifact) {
		if (codeArtifact != null) {
			parentCodeArtifact = Optional.of(codeArtifact);
		}
	}

	@Override
	public void setChildCodeArtifacts(List<CodeArtifact> codeArtifacts) {
		childCodeArtifacts = Optional.of(codeArtifacts);
	}
	
	@Override
	public void addChildCodeArtifact(CodeArtifact codeArtifact) {

		if (!childCodeArtifacts.isPresent()) {
			childCodeArtifacts = Optional.of(new ArrayList<CodeArtifact>());
		}
		
		childCodeArtifacts.get().add(codeArtifact);
	}
	
	@Override
	public void addChildCodeArtifacts(List<CodeArtifact> codeArtifacts) {
		
		if (!codeArtifacts.isEmpty()) {
			if (!childCodeArtifacts.isPresent()) {
				childCodeArtifacts = Optional.of(new ArrayList<CodeArtifact>());
			}
			childCodeArtifacts.get().addAll(codeArtifacts);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compilationUnit == null) ? 0 : compilationUnit.hashCode());

		int sum = 0;
		if (this.getSourceNode().isPresent()) {
			Node node = this.getSourceNode().get();
			if (node.getBegin().isPresent() && node.getEnd().isPresent()) {
				sum = node.getBegin().get().hashCode() + node.getEnd().get().hashCode();
			}
		}
		
		result = prime * result + sum;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCodeArtifact other = (AbstractCodeArtifact) obj;
		if (compilationUnit == null) {
			if (other.compilationUnit != null)
				return false;
		} else if (!compilationUnit.equals(other.compilationUnit))
			return false;
		
		if (!this.getSourceNode().isPresent() || !other.getSourceNode().isPresent()
				|| !this.getSourceNode().get().getRange().isPresent()
				|| !other.getSourceNode().get().getRange().isPresent()) {
			return false;
		} else {
			if (!this.getSourceNode().get().getRange().get().equals(other.getSourceNode().get().getRange().get())) {
				return false;
			}
		}
		
		return true;
	}


	protected Optional<PatternContext> patternContext;
	protected CompilationUnit compilationUnit;
	protected Optional<CodeArtifact> parentCodeArtifact = Optional.empty();
	protected Optional<List<CodeArtifact>> childCodeArtifacts = Optional.empty();
	
}
