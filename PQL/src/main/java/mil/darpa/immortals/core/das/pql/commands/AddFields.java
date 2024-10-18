package mil.darpa.immortals.core.das.pql.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClassField;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class AddFields extends AbstractCommand {

	public AddFields(String id, String targetBinding, List<JavaClassField> fields, boolean applyToAncestorClass) {
		setId(id);
		setTargetBinding(targetBinding);
		setFields(fields);
		this.applyToAncestorClass = applyToAncestorClass;
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		Set<JavaClass> processedClasses = new HashSet<>();
		
		String[] newFieldNames = new String[this.fields.size()];
		JavaClass javaClass = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			context.setCurrentRootFragmentPatternMatch(rfpm);
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent()) {
				if (applyToAncestorClass) {
					javaClass = cv.getCodeArtifact().get().getAncestorClass();
				} else {
					javaClass = (JavaClass) cv.getCodeArtifact().get();
				}
				if (!processedClasses.contains(javaClass)) {
					int fIndex = 0;
					for (JavaClassField f : fields) {
						javaClass.addField(f, context);
						newFieldNames[fIndex++] = f.getResolvedFieldName();
					}
					//Put chosen names in context for other commands to reference if needed
					rfpm.addBinding("newFieldNames", new ContextValue(ContextValueType.NameExpressionArray, newFieldNames));
					
					processedClasses.add(javaClass);
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
	private boolean applyToAncestorClass;
}
