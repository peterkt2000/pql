package mil.darpa.immortals.core.das.pql.commands;

import java.nio.file.Path;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class PrintResult extends AbstractCommand {

	public PrintResult() {}
	
	public PrintResult(String targetBinding) {
		setTargetBinding(targetBinding);
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		StringBuilder output = new StringBuilder();
		Path matchedFilePath = context.getCompilationUnit().getStorage().get().getPath();

		CodeArtifact ca = null;
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (output.length() > 0) {
				output.append(NL + NL);
			}
			if (cv.getCodeArtifact().isPresent()) {
				ca = cv.getCodeArtifact().get();
				output.append("Matched File: ").append(matchedFilePath.toString()).append(NL)
					.append("Start Position (Line:Column): ").append(ca.getStartPosition().line).append(":").append(ca.getStartPosition().column).append(NL)
					.append("End Position (Line:Column): ").append(ca.getEndPosition().line).append(":").append(ca.getEndPosition().column).append(NL)
					.append("Source Text:\n").append(ca.getSourceText());
			} else {
				//I don't think we'll trigger this case anymore (originally the idea was matches could result in
				//simple values versus always CodeArtifact instances).
				output.append("Matched File: ").append(matchedFilePath.toString()).append(NL)
				.append("Simple Matched Value:\n").append(cv.getValue());				
			}
		}
		
		context.getPqlExecutionResult().addFileOutput(matchedFilePath, output.toString());
	}

	@Override
	public boolean isModifyingCommand() {
		return false;
	}

	private static final String NL = System.lineSeparator();
}
