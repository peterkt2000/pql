package mil.darpa.immortals.core.das.pql.commands;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpression;
import mil.darpa.immortals.core.das.pql.PQLExpressionType;

public abstract class AbstractCommand implements Command {

	public abstract void execute(PQLContext context) throws Exception;
	
	@Override
	public String getTargetBinding() {
		return targetBinding;
	}

	@Override
	public void setTargetBinding(String targetBinding) {
		this.targetBinding = targetBinding;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	protected String evaluatePQLExpression(PQLExpression pe, PQLContext context) {

		String result = null;
		
		if (pe.getPQLExpressionType() == PQLExpressionType.Expression) {
			result = pe.getExpression();
		} else if (pe.getPQLExpressionType() == PQLExpressionType.ContextReference) {
			result = pe.getBindingEvaluator().evaluate(context);
		}
		
		return result;
		
	}


	protected String targetBinding;
	protected String id;

}
