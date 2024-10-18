package mil.darpa.immortals.core.das.pql.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.BodyDeclaration;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpression;
import mil.darpa.immortals.core.das.pql.Utilities;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;
import mil.darpa.immortals.core.das.pql.selectors.MethodDeclarationSelector;

public class AddGetterSetter extends AbstractCommand {

	public AddGetterSetter(String id, String targetBinding, String fieldType, PQLExpression fieldName,
			boolean applyToAncestorClass, boolean idempotent, boolean addGetter, boolean addSetter,
			Modifier getterAccessModifier, Modifier setterAccessModifier) {
		setId(id);
		setTargetBinding(targetBinding);
		setFieldType(fieldType);
		setFieldName(fieldName);
		setApplyToAncestorClass(applyToAncestorClass);
		setIdempotent(idempotent);
		setAddGetter(addGetter);
		setAddSetter(addSetter);
		setSetterAccessModifier(setterAccessModifier);
		setGetterAccessModifier(getterAccessModifier);
	}
	
	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		Set<JavaClass> processedClasses = new HashSet<>();
		
		JavaClass javaClass = null;
		Optional<JavaMethodDeclaration> getterJMD = null;
		Optional<JavaMethodDeclaration> setterJMD = null;
		String getterName = null;
		String setterName = null;
		String baseGetterName = null;
		String baseSetterName = null;
		MethodDeclarationSelector getterMDS = null;
		MethodDeclarationSelector setterMDS = null;
		List<String> parameterTypes = null;
		boolean setterNameCheckSatisfied = false;
		boolean getterNameCheckSatisfied = false;
		String resolvedFieldName = null;
		
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
					resolvedFieldName = evaluatePQLExpression(this.fieldName, context);
					if (this.fieldType.equals("boolean")) {
						baseGetterName = "is" + Utilities.toCamelCase(resolvedFieldName);
					} else {
						baseGetterName = "get" + Utilities.toCamelCase(resolvedFieldName);
					}

					baseSetterName = "set" + Utilities.toCamelCase(resolvedFieldName);
					
					String suffix = "";
					do {
						getterName = baseGetterName.concat(suffix);
						setterName = baseSetterName.concat(suffix);

						int index = 2;
						if (this.addGetter) {
							getterMDS = new MethodDeclarationSelector();
							getterMDS.setMethodName(Optional.of(getterName));
							getterMDS.setReturnType(Optional.of(this.fieldType));
							getterJMD = getterMDS.select(context, Optional.empty(), Optional.of(javaClass));
							if (!getterJMD.isPresent() || this.idempotent) {
								getterNameCheckSatisfied = true;
							}
						} else {
							getterNameCheckSatisfied = true;
						}
						
						if (this.addSetter) {
							setterMDS = new MethodDeclarationSelector();
							setterMDS.setMethodName(Optional.of(setterName));
							parameterTypes = new ArrayList<>();
							parameterTypes.add(this.fieldType);
							setterMDS.setReturnType(Optional.of("java.lang.Void"));
							setterMDS.setParameterTypes(Optional.of(parameterTypes));
							setterJMD = setterMDS.select(context, Optional.empty(), Optional.of(javaClass));
							if (!setterJMD.isPresent() || this.idempotent) {
								setterNameCheckSatisfied = true;
							}
						} else {
							setterNameCheckSatisfied = true;
						}
						suffix = String.valueOf(index++);
					} while (!(setterNameCheckSatisfied && getterNameCheckSatisfied));
					
					//Now add the getter and setter
					if (this.addGetter) {
						if (this.idempotent && getterJMD.isPresent()) {
							//We were told to add the getter, but it already exists and user indicated idempotency, so do nothing
						} else {
							//Here we know we just need to add getter using getterName
							BodyDeclaration<?> bd = StaticJavaParser.parseBodyDeclaration(this.getterAccessModifier.getOutput() + " " +
									Utilities.getTypeFromFullyQualifiedName(this.fieldType) + " " + getterName + "() {return this." + resolvedFieldName + ";}");
							javaClass.getClassDeclaration().addMember(bd);
						}
					}

					if (this.addSetter) {
						if (this.idempotent && setterJMD.isPresent()) {
							//We were told to add the setter, but it already exists and user indicated idempotency, so do nothing							
						} else {
							//Here we know we just need to add setter using setterName
							BodyDeclaration<?> bd = StaticJavaParser.parseBodyDeclaration(this.getterAccessModifier.getOutput() +
									" void " + setterName + "(" + Utilities.getTypeFromFullyQualifiedName(this.fieldType) + " " + resolvedFieldName +
									") {this." + resolvedFieldName + " = " + resolvedFieldName + ";}");
							javaClass.getClassDeclaration().addMember(bd);
						}
					}

					if (!Utilities.isBuiltInImport(this.fieldType)) {
						context.getCompilationUnit().addImport(this.fieldType, false, false);
					}

					//Put chosen names in context for other commands to reference if needed
					if (this.addGetter) {
						rfpm.addBinding("newGetterName", new ContextValue(ContextValueType.NameExpression, getterName));
					}
					
					if (this.addSetter) {
						rfpm.addBinding("newSetterName", new ContextValue(ContextValueType.NameExpression, setterName));
					}
					
					processedClasses.add(javaClass);
				}
			}
		}
	}
	
	public boolean isApplyToAncestorClass() {
		return applyToAncestorClass;
	}

	public void setApplyToAncestorClass(boolean applyToAncestorClass) {
		this.applyToAncestorClass = applyToAncestorClass;
	}


	public boolean isIdempotent() {
		return idempotent;
	}

	public void setIdempotent(boolean idempotent) {
		this.idempotent = idempotent;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	public Modifier getGetterAccessModifier() {
		return getterAccessModifier;
	}

	public void setGetterAccessModifier(Modifier getterAccessModifier) {
		this.getterAccessModifier = getterAccessModifier;
	}

	public Modifier getSetterAccessModifier() {
		return setterAccessModifier;
	}

	public void setSetterAccessModifier(Modifier setterAccessModifier) {
		this.setterAccessModifier = setterAccessModifier;
	}

	public boolean isAddGetter() {
		return addGetter;
	}

	public void setAddGetter(boolean addGetter) {
		this.addGetter = addGetter;
	}

	public boolean isAddSetter() {
		return addSetter;
	}

	public void setAddSetter(boolean addSetter) {
		this.addSetter = addSetter;
	}
	
	public PQLExpression getFieldName() {
		return fieldName;
	}

	public void setFieldName(PQLExpression fieldName) {
		this.fieldName = fieldName;
	}

	private boolean idempotent;
	private boolean applyToAncestorClass;
	private PQLExpression fieldName;
	private Modifier getterAccessModifier;
	private Modifier setterAccessModifier;
	private String fieldType;
	private boolean addGetter;
	private boolean addSetter;

}
