package mil.darpa.immortals.core.das.pql.commands;

import java.util.HashSet;
import java.util.Set;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class AddMethod extends AbstractCommand {

	public AddMethod(String id, String targetBinding, String code, boolean applyToAncestorClass) {
		setId(id);
		setTargetBinding(targetBinding);
		setCode(code);
		this.applyToAncestorClass = applyToAncestorClass;
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		Set<JavaClass> processedClasses = new HashSet<>();
		
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
					javaClass.addMethod(code, context, rfpm);
					processedClasses.add(javaClass);
				}
			}
		}
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	private String code;
	private boolean applyToAncestorClass;
}
