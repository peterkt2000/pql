package mil.darpa.immortals.core.das.pql.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpression;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class AddMethodInvocation extends AbstractCommand {

	public AddMethodInvocation(String id, String targetBinding, PQLExpression receiver,
			PQLExpression methodName, List<PQLExpression> arguments) {
		this.id = id;
		this.targetBinding = targetBinding;
		this.receiver = receiver;
		this.methodName = methodName;
		this.arguments = arguments;
	}
	
	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	@Override
	public void execute(PQLContext context) throws Exception {

		BlockStmt targetNode = null;
		String statement = null;
		String resolvedArguments = "";
		Set<CodeArtifact> processedNodes = new HashSet<>();
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);			
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent()) {
				if (cv.getCodeArtifact().get().getSourceNode().isPresent() &&
						cv.getCodeArtifact().get().getSourceNode().get() instanceof MethodDeclaration) { //Need to expand to all nodes that have a body of statements
					if (!processedNodes.contains(cv.getCodeArtifact().get())) {
						for (PQLExpression pe : this.arguments) {
							resolvedArguments = resolvedArguments + this.evaluatePQLExpression(pe, context) + ", ";
						}
						if (resolvedArguments.endsWith(", ")) {
							resolvedArguments = resolvedArguments.substring(0, resolvedArguments.length()-2);
						}
						targetNode = ((MethodDeclaration) cv.getCodeArtifact().get().getSourceNode().get()).getBody().get();
						statement = this.evaluatePQLExpression(this.getReceiver(), context) +
								"." + this.evaluatePQLExpression(this.methodName, context) +
								"(" + resolvedArguments + ");";
						targetNode.addStatement(0, StaticJavaParser.parseStatement(statement));
						processedNodes.add(cv.getCodeArtifact().get());
					}
				}
			}
		}
	}

	public PQLExpression getReceiver() {
		return receiver;
	}

	public void setReceiver(PQLExpression receiver) {
		this.receiver = receiver;
	}

	public PQLExpression getMethodName() {
		return methodName;
	}

	public void setMethodName(PQLExpression methodName) {
		this.methodName = methodName;
	}

	public List<PQLExpression> getArguments() {
		return arguments;
	}

	public void setArguments(List<PQLExpression> arguments) {
		this.arguments = arguments;
	}


	private PQLExpression receiver;
	private PQLExpression methodName;
	private List<PQLExpression> arguments;
	
}
