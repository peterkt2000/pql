package mil.darpa.immortals.core.das.pql.commands;

import mil.darpa.immortals.core.das.pql.PQLContext;

public interface Command {

	void execute(PQLContext context) throws Exception;
	String getTargetBinding();
	void setTargetBinding(String binding);
	boolean isModifyingCommand();
}
