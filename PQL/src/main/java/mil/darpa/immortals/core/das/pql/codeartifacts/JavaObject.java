package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.NameExpr;

import mil.darpa.immortals.core.das.pql.PQLContext;

public class JavaObject extends AbstractCodeArtifact {

	public JavaObject(PQLContext context) {
		super(context);
	}

	@Override
	public Position getStartPosition() {
		return nameExpression.getBegin().get();
	}

	@Override
	public Position getEndPosition() {
		return nameExpression.getEnd().get();
	}

	@Override
	public String getSourceText() {
		return nameExpression.toString();
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
		return Optional.ofNullable(nameExpression);
	}
	
	public NameExpr getNameExpression() {
		return nameExpression;
	}

	public void setNameExpression(NameExpr nameExpression) {
		this.nameExpression = nameExpression;
	}

	private NameExpr nameExpression;
	private JavaClass javaClass = null;
}
