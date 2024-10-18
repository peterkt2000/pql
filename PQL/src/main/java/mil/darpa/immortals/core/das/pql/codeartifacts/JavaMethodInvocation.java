package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.Statement;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;

public class JavaMethodInvocation extends AbstractCodeArtifact {

	public JavaMethodInvocation(PQLContext context) {
		super(context);
	}

	public MethodCallExpr getMethodCallExpr() {
		return methodCallExpr;
	}

	public void setMethodCallExpr(MethodCallExpr methodCallExpr) {
		this.methodCallExpr = methodCallExpr;
	}
	
	@Override
	public Position getStartPosition() {
		return methodCallExpr.getBegin().get();
	}

	@Override
	public Position getEndPosition() {
		return methodCallExpr.getEnd().get();
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
		
		Optional<Node> result = Optional.empty();
		
		if (getPatternContext().isPresent()) {
			if (getPatternContext().get() == PatternContext.Statement) {
				result = Optional.ofNullable(methodCallStatement);			
			} else if (getPatternContext().get() == PatternContext.Expression) {
				result = Optional.ofNullable(methodCallExpr);			
			}
		} else {
			result = Optional.ofNullable(methodCallExpr);
		}
		
		return result;
	}

	public Statement getMethodCallStatement() {
		return methodCallStatement;
	}

	public void setMethodCallStatement(Statement methodCallStatement) {
		this.methodCallStatement = methodCallStatement;
	}
	
	public JavaObject getTargetObjectReceiver() {
		return targetObjectReceiver;
	}

	public void setTargetObjectReceiver(JavaObject targetObjectReceiver) {
		this.targetObjectReceiver = targetObjectReceiver;
	}

	private MethodCallExpr methodCallExpr = null;
	private Statement methodCallStatement = null;
	private JavaClass javaClass = null;
	private JavaObject targetObjectReceiver = null;

}
