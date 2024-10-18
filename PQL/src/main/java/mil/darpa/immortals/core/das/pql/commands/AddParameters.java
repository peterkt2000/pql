package mil.darpa.immortals.core.das.pql.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpressionType;
import mil.darpa.immortals.core.das.pql.Utilities;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaParameter;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class AddParameters extends AbstractCommand {

	public AddParameters(String id, String targetBinding, List<JavaParameter> parameters) {
		setId(id);
		setTargetBinding(targetBinding);
		this.parameters = parameters;
	}

	@Override
	public void execute(PQLContext context) throws Exception {

		Set<JavaMethodDeclaration> processedJMDS = new HashSet<>();
		
		//This command expects the targetBinding to point to a JavaMethodDeclaration code artifact
		JavaMethodDeclaration jmd = null;
		Set<String> parameterNames = new HashSet<>();
		String[] newParameterNames = new String[this.parameters.size()];
		String desiredParameterName = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);
			ContextValue cv = rfpm.getBinding(this.targetBinding);
			if (cv.getCodeArtifact().isPresent()) {
				jmd = (JavaMethodDeclaration) cv.getCodeArtifact().get();
				
				if (!processedJMDS.contains(jmd)) {
					MethodDeclaration md = jmd.getMethodDeclaration();
					parameterNames.clear();
					//Get all parameter names so we can pick a unique name for new parameter using
					//the user-provided value as the default
					md.getParameters().forEach(n -> parameterNames.add(n.getNameAsString()));
					
					//Do the work here to add the parameters to the method declaration
					int newPosition = 0;
					int pIndex = 0;
					for (JavaParameter jp : this.parameters) {
						if (jp.getAddAfterPosition() < 0) jp.setAddAfterPosition(0);
						//Check if user specified to add after a position that is greater than number of parameters
						if (md.getParameters().size() == 0) {
							newPosition = 0;
						} else {
							if (jp.getAddAfterPosition() > md.getParameters().size()) {
								newPosition = md.getParameters().size() + 1;
							} else {
								//one-based counting; add after position user specifies
								//You don't need to add 1 to this since the list is zero-based
								newPosition = jp.getAddAfterPosition();
							}
						}
						
						Parameter p = new Parameter();
						p.setFinal(jp.isFinalModifier());

						if (jp.getName().getPQLExpressionType() == PQLExpressionType.Expression) {
							desiredParameterName = jp.getName().getExpression();
						} else if (jp.getName().getPQLExpressionType() == PQLExpressionType.ContextReference) {
							desiredParameterName = jp.getName().getBindingEvaluator().evaluate(context);
						}

						p.setName(Utilities.getUniqueName(desiredParameterName, parameterNames));
						p.setType(Utilities.getTypeFromFullyQualifiedName(jp.getType()));
						if (newPosition >= md.getParameters().size()) {
							md.addParameter(p);
						} else {
							md.getParameters().add(newPosition, p);
						}
						parameterNames.add(p.getNameAsString());
						newParameterNames[pIndex++] = p.getNameAsString();
						if (!Utilities.isBuiltInImport(jp.getType())) {
							context.getCompilationUnit().addImport(jp.getType(), false, false);
						}
					}
					//Put chosen names in context for other commands to reference if needed
					rfpm.addBinding("newParameterNames", new ContextValue(ContextValueType.NameExpressionArray, newParameterNames));
					
					processedJMDS.add(jmd);
				}
			}
		}
	}
		
	@Override
	public boolean isModifyingCommand() {
		return true;
	}
	
	private List<JavaParameter> parameters;
}
