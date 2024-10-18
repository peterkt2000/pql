package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.LambdaExpr;

import mil.darpa.immortals.core.das.pql.PQLContext;

public class LambdaExpression extends AbstractCodeArtifact {

	public LambdaExpression(PQLContext context) {
		super(context);
	}

	@Override
	public Position getStartPosition() {
		return lambdaExpression.getBegin().get();
	}

	@Override
	public Position getEndPosition() {
		return lambdaExpression.getEnd().get();
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
		return this.javaClass;
	}

	@Override
	public void setAncestorClass(JavaClass javaClass) {
		this.javaClass = javaClass;
	}

	@Override
	public Optional<Node> getSourceNode() {
		return Optional.ofNullable(lambdaExpression);
	}
	
	public LambdaExpr getLambdaExpression() {
		return lambdaExpression;
	}

	public void setLambdaExpression(LambdaExpr lambdaExpression) {
		this.lambdaExpression = lambdaExpression;
	}

	private LambdaExpr lambdaExpression;
	private JavaClass javaClass;
}
