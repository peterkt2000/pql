package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.BlockStmt;

import mil.darpa.immortals.core.das.pql.PQLContext;

public class JavaBlockStatement extends AbstractCodeArtifact {

	public JavaBlockStatement(PQLContext context) {
		super(context);
	}
	
	@Override
	public Position getStartPosition() {

		if (getSourceNode().isPresent()) {
			return getSourceNode().get().getBegin().get();
		} else {
			return null;
		}
	}

	@Override
	public Position getEndPosition() {
		
		if (getSourceNode().isPresent()) {
			return getSourceNode().get().getEnd().get();
		} else {
			return null;
		}
	}

	@Override
	public String getSourceText() {

		String result = "";
		
		if (getSourceNode().isPresent()) {
			result = getSourceNode().get().toString();
		}
		
		return result;
	}

	@Override
	public JavaClass getAncestorClass() {
		return javaClass;
	}

	@Override
	public void setAncestorClass(JavaClass javaClass) {
		this.javaClass = javaClass;
	}

	@Override
	public Optional<Node> getSourceNode() {
		return Optional.ofNullable(blockStmt);
	}

	private BlockStmt blockStmt = null;
	private JavaClass javaClass = null;
}
