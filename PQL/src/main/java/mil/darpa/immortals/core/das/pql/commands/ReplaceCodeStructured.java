package mil.darpa.immortals.core.das.pql.commands;

import java.util.Optional;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.Utilities;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class ReplaceCodeStructured extends AbstractCommand {

	public ReplaceCodeStructured(String id, String targetBinding, String replacement) {
		setId(id);
		setTargetBinding(targetBinding);
		setReplacement(replacement);
	}
	
	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		String replacementCode = null;
		CodeArtifact ca = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);			
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent()) {
				ca = cv.getCodeArtifact().get();
				if (ca.getPatternContext().orElse(PatternContext.Expression) == PatternContext.Statement && ca.getContainingStatement().isPresent()) {
					try {
						replacementCode = Utilities.processCode(this.replacement, context, rfpm);
						//Use StaticJavaParser.parseExpression() for expression context
						Optional<BlockStmt> parentBlock = ca.getSourceNode().get().findAncestor(BlockStmt.class);
						if (parentBlock.isPresent()) {
							BlockStmt newBlock = StaticJavaParser.parseBlock("{" + replacementCode + "}");
							for (Statement s : newBlock.getStatements()) {
								parentBlock.get().getStatements()
									.addBefore(s, ca.getContainingStatement().get());
							}
							parentBlock.get().addOrphanComment(new LineComment(ca.getSourceNode().get().getTokenRange().get(), 
									ca.getSourceText()));
						}
						try {
							ca.getSourceNode().get().remove();
						} catch (Exception e) {
							context.getPqlExecutionResult().addMessage("Error during code replacement on file: " + context.getCompilationUnitFileName() +
									"\nCould not remove replaced code:\n" + ca.getSourceText());

						}
					} catch (Exception e) {
						context.getPqlExecutionResult().addMessage("Error during code replacement on file: " + context.getCompilationUnitFileName() +
							"\nAffected Code:\n" + ca.getSourceText());
					}
				}
			}
		}
	}

	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	private String replacement;

}
