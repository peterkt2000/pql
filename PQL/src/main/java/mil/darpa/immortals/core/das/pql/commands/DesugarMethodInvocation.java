package mil.darpa.immortals.core.das.pql.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClassField;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodInvocation;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class DesugarMethodInvocation extends AbstractCommand {

	public DesugarMethodInvocation(String id, String targetBinding) {
		setId(id);
		setTargetBinding(targetBinding);
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		Set<JavaMethodInvocation> processedMethodInvocations = new HashSet<>();
		
		JavaMethodInvocation jmi = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent()) {
				jmi = (JavaMethodInvocation) cv.getCodeArtifact().get();
				if (!processedMethodInvocations.contains(jmi)) {
					MethodCallExpr sn = (MethodCallExpr) jmi.getMethodCallExpr();
					if (sn.getArguments().size() > 0 && sn.getArgument(0).isLambdaExpr()) {
						LambdaExpr le = sn.getArgument(0).asLambdaExpr();

						ResolvedType functionalInterfaceType = le.calculateResolvedType();
						ResolvedMethodDeclaration rmd = functionalInterfaceType.asReferenceType().getAllMethods().stream().filter(t -> t.isAbstract()).findFirst().get();
						String abstractMethodSignature = rmd.accessSpecifier().asString() + " " + rmd.getReturnType().describe() + " " + rmd.getName() + "(";
						for (int parameterIndex = 0; parameterIndex < rmd.getNumberOfParams(); parameterIndex++) {
							abstractMethodSignature += rmd.getParam(parameterIndex).describeType() + " " + le.getParameter(parameterIndex).getNameAsString();
						}
						abstractMethodSignature += ")";
						String rawExpression = "new " + functionalInterfaceType.describe() + "() { " +
								abstractMethodSignature + "{" + le.getBody().toString() + "}}";
						Expression anonExpression = StaticJavaParser.parseExpression(rawExpression);
						sn.getArgument(0).remove();
						sn.getArguments().add(anonExpression);
						processedMethodInvocations.add(jmi);
					}
				}
			}
		}
	}
	
	public List<JavaClassField> getFields() {
		return fields;
	}

	public void setFields(List<JavaClassField> fields) {
		this.fields = fields;
	}
	
	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	private List<JavaClassField> fields;
}
