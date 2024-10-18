package mil.darpa.immortals.core.das.pql;

public interface IPQLProgram {
	
	public PQLExecutionResult run(String sourceToExamine, String targetForModifications, 
			String sourceTypeSolverPaths, String jarTypeSolverFiles) throws Exception;

}
