package mil.darpa.immortals.core.das.pql;

public class PQLExpression {

	public PQLExpression(BindingEvaluator<String> bindingEvaluator) {
		this.pqlExpressionType = PQLExpressionType.ContextReference;
		this.bindingEvaluator = bindingEvaluator;
	}
	
	public PQLExpression(String expression) {
		this.pqlExpressionType = PQLExpressionType.Expression;
		this.expression = expression;
	}	
		
	public BindingEvaluator<String> getBindingEvaluator() {
		return bindingEvaluator;
	}

	public PQLExpressionType getPQLExpressionType() {
		return pqlExpressionType;
	}

	public String getExpression() {
		return expression;
	}
	
	private BindingEvaluator<String> bindingEvaluator;
	private PQLExpressionType pqlExpressionType;
	private String expression;
}
