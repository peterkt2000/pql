package mil.darpa.immortals.core.das.pql;

@FunctionalInterface
public interface BindingEvaluator<R> {

	public R evaluate(PQLContext pqlContext);
	
}
