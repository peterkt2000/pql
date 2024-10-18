package mil.darpa.immortals.core.das.pql;

import java.util.Stack;
import java.util.stream.Collectors;

import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.generated.PQLBaseListener;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddFieldsContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddGetterSetterContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddImportsContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddMethodContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddMethodInvocationContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.AddParametersContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ClassDeclarationContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.CodePatternContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.DesugarMethodInvocationContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.FieldContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.FragmentOptionsContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.FragmentPatternContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.GenericizedTypeContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ImportTypeContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.MethodDeclarationContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.MethodInvocationContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ParameterContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.PqlExpressionContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.PrintMatchContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ProgContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ReferenceSearchContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.ReplaceContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.RootFragmentContext;
import mil.darpa.immortals.core.das.pql.generated.PQLParser.RootFragmentOptionsContext;

public class PQLListener extends PQLBaseListener {

	public PQLListener() {}
	
	@Override
	public void enterAddMethodInvocation(AddMethodInvocationContext ctx) {

		String arguments = getVariableName("arguments");
		addStatement("List<PQLExpression> " + arguments + " = new ArrayList<>();");

		if (ctx.arguments() != null && ctx.arguments().argument().size() > 0) {
			for (int x = 0; x < ctx.arguments().argument().size(); x++) {
				String argument = getVariableName("argument");
				processPQLExpression(argument, ctx.arguments().argument().get(x).pqlExpression());
				addStatement(arguments + ".add(" + argument + ");");
			}
		}
		
		String receiver = getVariableName("receiver");
		processPQLExpression(receiver, ctx.receiver().pqlExpression());

		String methodName = getVariableName("methodName");
		processPQLExpression(methodName, ctx.methodToInvoke().pqlExpression());

		addStatement(PE_VAR + ".getCommands().add(new AddMethodInvocation(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + ","
				+ receiver + ", "
				+ methodName + ", "
				+ arguments
				+ "));");
	}

	@Override
	public void enterAddGetterSetter(AddGetterSetterContext ctx) {

		boolean applyToAncestorClass = Utilities.parseBoolean(ctx.applyToAncestorClass().getText());
		boolean idempotent = Utilities.parseBoolean(ctx.idempotent().getText());
		boolean addGetter = Utilities.parseBoolean(ctx.addGetter().getText());
		boolean addSetter = Utilities.parseBoolean(ctx.addSetter().getText());
		String getterAccessModifier = Modifier.class.getName() + "." + ctx.getterAccessModifier().getText();
		String setterAccessModifier = Modifier.class.getName() + "." + ctx.setterAccessModifier().getText();
		
		String fieldName = getVariableName("fieldName");
		processPQLExpression(fieldName, ctx.fieldName().pqlExpression());
		
		addStatement(PE_VAR + ".getCommands().add(new AddGetterSetter(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + ","
				+ DQ + ctx.fieldType().genericizedType().getText() + DQ + ","
				+ fieldName + ", "
				+ applyToAncestorClass + ", "
				+ idempotent + ", " 
				+ addGetter + ", "
				+ addSetter + ", "
				+ getterAccessModifier + ", "
				+ setterAccessModifier
				+ "));");
	}



	@Override
	public void enterAddParameters(AddParametersContext ctx) {
		
		String parametersArray = getVariableName("parameters");

		addStatement("List<JavaParameter> " + parametersArray + " = new ArrayList<>();");
		
		String parameterName = getVariableName("parameterName");
				
		for (ParameterContext pc : ctx.parameters().parameter()) {
			processPQLExpression(parameterName, pc.parameterName().pqlExpression());

			addStatement(parametersArray + ".add(new JavaParameter(" +
					String.valueOf(Utilities.parseBoolean(pc.finalModifier().getText())) + ", " +
					DQ + pc.parameterType().genericizedType().getText() + DQ + ", " + 
					parameterName + ", " +
					pc.parameterPosition().getText() + "));");
		}
		
		addStatement(PE_VAR + ".getCommands().add(new AddParameters(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + "," + parametersArray + "));");

	}

	@Override
	public void enterDesugarMethodInvocation(DesugarMethodInvocationContext ctx) {
		
		addStatement(PE_VAR + ".getCommands().add(new DesugarMethodInvocation(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + "));");

	}

	
	@Override
	public void enterMethodDeclaration(MethodDeclarationContext ctx) {

		String id = ctx.bindingDecl().getText();
		
		String accessModifier = null;
		String staticModifier = null;
		String abstractModifier = null;
		String finalModifier = null;
		String nativeModifier = null;
		String synchronizedModifier = null;
		String returnType = null;
		String methodName = null;
		String throwsTypes = null;
		String parameters = null;

		if (ctx.parameterTypes() != null) {
			parameters = getVariableName("parameters");
			addStatement("List<String> " + parameters + " = new ArrayList<>();");
	
			if (ctx.parameterTypes() != null && ctx.parameterTypes().genericizedType().size() > 0) {
				for (GenericizedTypeContext gtc : ctx.parameterTypes().genericizedType()) {
					addStatement(parameters + ".add(" + DQ + gtc.getText() + DQ + ");");
				}
			}
		}

		if (ctx.throwsTypes() != null) {
			throwsTypes = getVariableName("throwsTypes");
			addStatement("List<String> " + throwsTypes + " = new ArrayList<>();");
	
			if (ctx.throwsTypes() != null && ctx.throwsTypes().genericizedType().size() > 0) {
				for (GenericizedTypeContext gtc : ctx.throwsTypes().genericizedType()) {
					addStatement(throwsTypes + ".add(" + DQ + gtc.getText() + DQ + ");");
				}
			}
		}
		
		if (ctx.accessModifier() != null) {
			accessModifier = Modifier.class.getName() + "." + ctx.accessModifier().getText();
		}
		
		if (ctx.staticModifier() != null) {
			staticModifier = ctx.staticModifier().getText();
		}

		if (ctx.abstractModifier() != null) {
			abstractModifier = ctx.abstractModifier().getText();
		}

		if (ctx.finalModifier() != null) {
			finalModifier = ctx.finalModifier().getText();
		}
		
		if (ctx.nativeModifier() != null) {
			nativeModifier = ctx.nativeModifier().getText();
		}

		if (ctx.synchronizedModifier() != null) {
			synchronizedModifier = ctx.synchronizedModifier().getText();
		}

		if (ctx.returnType() != null) {
			returnType = ctx.returnType().genericizedType().getText();
		}

		if (ctx.methodName() != null) {
			methodName = ctx.methodName().getText();
		}

		String methodDeclarationPatternVar = getVariableName("mdp");
		
		addStatement("MethodDeclarationPattern " + methodDeclarationPatternVar + " = new MethodDeclarationPattern(" + DQ + id + DQ + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(accessModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(staticModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(abstractModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(finalModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(nativeModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(synchronizedModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableString(returnType) + ")" + ", " +				
				"Optional.ofNullable(" + Utilities.getNullableString(methodName) + ")" + ", " +				
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(parameters) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(throwsTypes) + ")" + 
				");");
		
		//This code artifact is now the current fragment that will own its children
		fragmentStack.push(methodDeclarationPatternVar);
		
		DuplicatePolicy duplicatePolicy = null;
		
		if (ctx.duplicatePolicy() != null) {
			duplicatePolicy = DuplicatePolicy.valueOf(ctx.duplicatePolicy().getText());
		} else {
			duplicatePolicy = DuplicatePolicy.CycleChildren;
		}
		
		SearchPolicy childSearchPolicy = null;
		
		if (ctx.childSearchPolicy() != null) {
			childSearchPolicy = SearchPolicy.valueOf(ctx.childSearchPolicy().getText());
		} else {
			childSearchPolicy = SearchPolicy.RestartAtEndLastMatch;
		}
		
		addStatement(fragmentStack.peek() + ".setDuplicatePolicy(" + duplicatePolicy.getClass().getName() + "." + duplicatePolicy + ");");
		addStatement(fragmentStack.peek() + ".setChildSearchPolicy(" + childSearchPolicy.getClass().getName() + "." + childSearchPolicy + ");");

	}
	
	@Override
	public void exitMethodDeclaration(MethodDeclarationContext ctx) {
		String currentFragment = fragmentStack.pop();
		addStatement(fragmentStack.peek() + ".addChildCodeArtifactPattern(" + currentFragment + ");");
		addStatement(currentFragment + ".setParentCodeArtifactPattern(" + fragmentStack.peek() + ");");
	}

	@Override
	public void enterClassDeclaration(ClassDeclarationContext ctx) {

		String id = ctx.bindingDecl().getText();
		
		String superClassType = null;
		String accessModifier = null;
		String staticModifier = null;
		String finalModifier = null;
		String interfaceTypes = null;
		String abstractModifier = null;
		String nestedClass = null;

		if (ctx.superClassType() != null) {
			superClassType = ctx.superClassType().genericizedType().getText();
		}

		if (ctx.interfaceTypes() != null) {
			interfaceTypes = getVariableName("interfaceTypes");
			addStatement("List<String> " + interfaceTypes + " = new ArrayList<>();");
	
			if (ctx.interfaceTypes() != null && ctx.interfaceTypes().genericizedType().size() > 0) {
				for (GenericizedTypeContext gtc : ctx.interfaceTypes().genericizedType()) {
					addStatement(interfaceTypes + ".add(" + DQ + gtc.getText() + DQ + ");");
				}
			}
		}

		if (ctx.accessModifier() != null) {
			accessModifier = Modifier.class.getName() + "." + ctx.accessModifier().getText();
		}
		
		if (ctx.staticModifier() != null) {
			staticModifier = ctx.staticModifier().getText();
		}

		if (ctx.finalModifier() != null) {
			finalModifier = ctx.finalModifier().getText();
		}

		if (ctx.abstractModifier() != null) {
			abstractModifier = ctx.abstractModifier().getText();
		}
		
		if (ctx.nestedClass() != null) {
			nestedClass = ctx.nestedClass().getText();
		}

		String classDeclarationPatternVar = getVariableName("cdp");

		addStatement("ClassDeclarationPattern " + classDeclarationPatternVar + " = new ClassDeclarationPattern(" + DQ + id + DQ + ", " +
				"Optional.ofNullable(" + Utilities.getNullableString(superClassType) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(interfaceTypes) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(staticModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(finalModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(accessModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(abstractModifier) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableBoolean(nestedClass) + ")" +
				");");
		
		//This code artifact is now the current fragment that will own its children
		fragmentStack.push(classDeclarationPatternVar);
		
		DuplicatePolicy duplicatePolicy = null;
		
		if (ctx.duplicatePolicy() != null) {
			duplicatePolicy = DuplicatePolicy.valueOf(ctx.duplicatePolicy().getText());
		} else {
			duplicatePolicy = DuplicatePolicy.CycleChildren;
		}
		
		SearchPolicy childSearchPolicy = null;
		
		if (ctx.childSearchPolicy() != null) {
			childSearchPolicy = SearchPolicy.valueOf(ctx.childSearchPolicy().getText());
		} else {
			childSearchPolicy = SearchPolicy.RestartAtEndLastMatch;
		}
		
		addStatement(fragmentStack.peek() + ".setDuplicatePolicy(" + duplicatePolicy.getClass().getName() + "." + duplicatePolicy + ");");
		addStatement(fragmentStack.peek() + ".setChildSearchPolicy(" + childSearchPolicy.getClass().getName() + "." + childSearchPolicy + ");");

	}

	@Override
	public void exitClassDeclaration(ClassDeclarationContext ctx) {
		String currentFragment = fragmentStack.pop();
		addStatement(fragmentStack.peek() + ".addChildCodeArtifactPattern(" + currentFragment + ");");
		addStatement(currentFragment + ".setParentCodeArtifactPattern(" + fragmentStack.peek() + ");");
	}
	
	private void processPQLExpression(String variableName, PqlExpressionContext pec) {
		
		String bindingLookupKey = null;
		String expression = null;

		if (pec.contextReferences() != null) {
			String bindingEvaluator = getVariableName("bindingEvaluator");
			if (pec.contextReferences().stringContextReference() != null) {
				bindingLookupKey = pec.contextReferences().stringContextReference().bindingLookup().getText();
				addStatement("BindingEvaluator<String> " + bindingEvaluator + 
						" = (pqlContext) -> pqlContext.getBindingAsString(" + DQ + bindingLookupKey + DQ + ");");
			} else if (pec.contextReferences().stringArrayContextReference() != null) {
				bindingLookupKey = pec.contextReferences().stringArrayContextReference().bindingLookup().getText();
				addStatement("BindingEvaluator<String> " + bindingEvaluator + 
						" = (pqlContext) -> pqlContext.getBindingAsString(" + DQ + bindingLookupKey + DQ + "," + 
						pec.contextReferences().stringArrayContextReference().lookupIndex().getText() + ");");
			}
			addStatement("PQLExpression " + variableName + 
					" = new PQLExpression(" + bindingEvaluator + ");");
		} else if (pec.nameExpression() != null) {
			expression = pec.nameExpression().getText();
				addStatement("PQLExpression " + variableName + 
						" = new PQLExpression(" + DQ + expression + DQ + ");");
		} else if (pec.stringLiteral() != null) {
			expression = pec.stringLiteral().getText();
			addStatement("PQLExpression " + variableName + 
					" = new PQLExpression(" + DQ + expression.replace("\"", "\\\"") + DQ + ");");			
		}
	}

	@Override
	public void enterAddFields(AddFieldsContext ctx) {

		boolean applyToAncestorClass = Utilities.parseBoolean(ctx.applyToAncestorClass().getText());

		String fieldsArrayVar = getVariableName("fields");

		addStatement("List<JavaClassField> " + fieldsArrayVar + " = new ArrayList<>();");
		
		String initializer = null;
		String fieldName = null;
		
		for (FieldContext fc : ctx.fields().field()) {
			initializer = getVariableName("initializer");
			fieldName = getVariableName("fieldName");
			
			processPQLExpression(fieldName, fc.fieldName().pqlExpression());
			processPQLExpression(initializer, fc.initializer().pqlExpression());
			
			addStatement(fieldsArrayVar + ".add(new JavaClassField(" +
					Utilities.parseBoolean(fc.idempotent().getText()) + ", " +
					"Modifier." + fc.accessModifier().getText() + ", " +
					Utilities.parseBoolean(fc.staticModifier().getText()) + "," +
					Utilities.parseBoolean(fc.finalModifier().getText()) + ", " +
					DQ + fc.fieldType().genericizedType().getText() + DQ + ", " +
					fieldName + ", " +
					initializer + 
					"));");
		}
				
		addStatement(PE_VAR + ".getCommands().add(new AddFields(" + DQ + ctx.bindingDecl().getText() + DQ + ", " 
				+ DQ + ctx.targetBinding().getText() + DQ + ", "
				+ fieldsArrayVar + "," + applyToAncestorClass + "));");
	}

	@Override
	public void enterAddMethod(AddMethodContext ctx) {
		
		boolean applyToAncestorClass = Utilities.parseBoolean(ctx.applyToAncestorClass().getText());
		String code = ctx.codeBlock().CODE_BLOCK().getText();
		
		if (code.startsWith("@#") && code.endsWith("#@")) {
			code = code.substring(2, code.length()-2);
		}
		
		String[] codeLines = code.split("\n");
		
		StringBuilder cf = new StringBuilder();
		
		int x = 0;
		for (; x < codeLines.length-1; x++) {
			cf.append(DQ + codeLines[x].replaceAll("\"", "\\\\\"") + "\\n" + DQ + " + \n");
		}
		
		cf.append(DQ + codeLines[x].replaceAll("\"", "\\\"") + "\\n" + DQ);
		
		String newMethodVar = getVariableName("newMethod");
		addStatement("String " + newMethodVar + " = " + cf.toString() + ';');
		addStatement(PE_VAR + ".getCommands().add(new AddMethod(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + ", "
				+ newMethodVar + "," + applyToAncestorClass + "));");
	}
	
	@Override
	public void enterPrintMatch(PrintMatchContext ctx) {
		addStatement(PE_VAR + ".getCommands().add(new PrintResult(" + DQ + ctx.targetBinding().getText() + DQ + "));");
	}

	@Override
	public void enterProg(ProgContext ctx) {
		
		addClassStructure();
		
		addStatement("@Override public PQLExecutionResult run(String sourceToModify, String targetForModification, String sourceTypeSolverPaths, String jarTypeSolverFiles) throws Exception {");
		
		addStatement("Path source = Paths.get(sourceToModify);");
		addStatement("Path target = Paths.get(targetForModification);");
		
		addStatement("List<Path> sourceTypeSolvers = Utilities.parsePaths(sourceTypeSolverPaths, \";\");");
		addStatement("List<Path> jarTypeSolvers = Utilities.parsePaths(jarTypeSolverFiles, \";\");");
		
		addStatement("PQLEngine " + PE_VAR + " = new PQLEngine(source, target, sourceTypeSolvers, jarTypeSolvers);");

	}

	@Override
	public void exitProg(ProgContext ctx) {
		addStatement("return " + PE_VAR + ".process();");
		addStatement("}");
		addStatement("}");
	}
	
	@Override
	public void enterRootFragment(RootFragmentContext ctx) {
		pushRootFragment(ctx.rootFragmentOptions());
	}

	@Override
	public void exitRootFragment(RootFragmentContext ctx) {
		addStatement(PE_VAR + ".setRootFragmentPattern(" + fragmentStack.pop() + ");");
	}
		
	@Override
	public void enterFragmentPattern(FragmentPatternContext ctx) {
		pushFragment(ctx.fragmentOptions());
	}

	@Override
	public void exitFragmentPattern(FragmentPatternContext ctx) {
		String currentFragment = fragmentStack.pop();
		addStatement(fragmentStack.peek() + ".addChildCodeArtifactPattern(" + currentFragment + ");");
		addStatement(currentFragment + ".setParentCodeArtifactPattern(" + fragmentStack.peek() + ");");
	}
	
	@Override
	public void enterCodePattern(CodePatternContext ctx) {
		// TODO Auto-generated method stub
		super.enterCodePattern(ctx);
	}

	@Override
	public void exitCodePattern(CodePatternContext ctx) {
		// TODO Auto-generated method stub
		super.exitCodePattern(ctx);
	}

	@Override
	public void enterMethodInvocation(MethodInvocationContext ctx) {

		String id = ctx.bindingDecl().getText();

		String receiverType = null;
		String methodName = null;
		String argumentTypes = null;
		PatternContext patternContext = null;
		String patternContextArgument = null;
		
		if (ctx.receiverType() != null) {
			receiverType = ctx.receiverType().genericizedType().getText();
		}
		
		if (ctx.methodName() != null) {
			methodName = ctx.methodName().getText();
		}
		
		if (ctx.patternContext() != null) {
			patternContext = PatternContext.valueOf(ctx.patternContext().getText());
			patternContextArgument = patternContext.getClass().getName() + "." + patternContext;
		}

		if (ctx.argumentTypes() != null) {
			argumentTypes = getVariableName("argumentTypes");
			addStatement("List<String> " + argumentTypes + " = new ArrayList<>();");
	
			if (ctx.argumentTypes() != null && ctx.argumentTypes().genericizedType().size() > 0) {
				for (GenericizedTypeContext gtc : ctx.argumentTypes().genericizedType()) {
					addStatement(argumentTypes + ".add(" + DQ + gtc.getText() + DQ + ");");
				}
			}
		}
				
		String methodInvocationPatternVar = getVariableName("mip");

		addStatement("MethodInvocationPattern " + methodInvocationPatternVar + " = new MethodInvocationPattern(" + DQ + id + DQ + ", " +
				"Optional.ofNullable(" + Utilities.getNullableString(receiverType) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableString(methodName) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(patternContextArgument) + ")" + ", " +
				"Optional.ofNullable(" + Utilities.getNullableCodeSnippet(argumentTypes) + ")" +
				");");

		DuplicatePolicy duplicatePolicy = null;
		
		if (ctx.duplicatePolicy() != null) {
			duplicatePolicy = DuplicatePolicy.valueOf(ctx.duplicatePolicy().getText());
		} else {
			duplicatePolicy = DuplicatePolicy.SearchNextUnique;
		}

		addStatement(methodInvocationPatternVar + ".setDuplicatePolicy(" + duplicatePolicy.getClass().getName() + "." + duplicatePolicy + ");");
		addStatement(fragmentStack.peek() + ".addChildCodeArtifactPattern(" + methodInvocationPatternVar + ");");
	}
	
	@Override
	public void enterReferenceSearch(ReferenceSearchContext ctx) {
		
		String binding = ctx.bindingDecl().getText();
		String type = ctx.type().getText();
		
		String declBindingVar = getVariableName("declarationBinding");
		String refSearchVar = getVariableName("rsp");
		
		addStatement("TypeBinding " + declBindingVar + " = new TypeBinding(" + DQ + type + DQ + "," + DQ + binding + DQ + ");");
		addStatement("ReferenceSearchPattern " + refSearchVar + " = new ReferenceSearchPattern(" + declBindingVar + "," + 
				DQ + ctx.anchor().getText() + DQ + "," + DQ + type + DQ + ");");
		
		addStatement(fragmentStack.peek() + ".addChildCodeArtifactPattern(" + refSearchVar + ");");

	}

	@Override
	public void enterReplace(ReplaceContext ctx) {

		String code = ctx.codeBlock().CODE_BLOCK().getText();
		
		if (code.startsWith("@#") && code.endsWith("#@")) {
			code = code.substring(2, code.length()-2);
		}
		
		String[] codeLines = code.split("\n");
		
		StringBuilder cf = new StringBuilder();
		
		int x = 0;
		for (; x < codeLines.length-1; x++) {
			cf.append(DQ + codeLines[x].replaceAll("\"", "\\\\\"") + "\\n" + DQ + " + \n");
		}
		
		cf.append(DQ + codeLines[x].replaceAll("\"", "\\\"") + "\\n" + DQ);
		
		String replacementVar = getVariableName("replacementCode");
		addStatement("String " + replacementVar + " = " + cf.toString() + ';');
		addStatement(PE_VAR + ".getCommands().add(new ReplaceCodeStructured(" + DQ + ctx.bindingDecl().getText() + DQ + ", "
				+ DQ + ctx.targetBinding().getText() + DQ + ", " +
				replacementVar + "));");
	}
	
	@Override
	public void enterAddImports(AddImportsContext ctx) {
		
		String importsVar = getVariableName("imports");
		
		addStatement("List<String> " + importsVar + " = new ArrayList<>();");
		
		for (ImportTypeContext it : ctx.imports().importType()) {
			String importDesc = it.IDENTIFIER().stream().map(i -> i.getText()).collect(Collectors.joining("."));
			addStatement(importsVar + ".add(" + DQ + importDesc + DQ + ");");
		}
		
		addStatement(PE_VAR + ".getCommands().add(new AddImports(" + importsVar + "));");

	}
	
	public String getProgram() {
		return sb.toString();
	}
	
	private void addStatement(String statement) {
		sb.append(statement + NL);
	}
	
	private void addClassStructure() {
		
		addStatement("import java.io.File;");
		addStatement("import java.nio.file.Path;");
		addStatement("import java.nio.file.Paths;");
		addStatement("import java.util.ArrayList;");
		addStatement("import java.util.List;");
		addStatement("import java.util.Optional;");
		addStatement("import java.util.Arrays;");
		
		addStatement("import mil.darpa.immortals.core.das.pql.*;");
		addStatement("import mil.darpa.immortals.core.das.pql.codeartifacts.*;");
		addStatement("import mil.darpa.immortals.core.das.pql.codeartifactpatterns.*;");
		addStatement("import mil.darpa.immortals.core.das.pql.commands.*;");
		addStatement("import mil.darpa.immortals.core.das.pql.exceptions.*;");
		addStatement("import mil.darpa.immortals.core.das.pql.selectors.*;");
		addStatement("import com.github.javaparser.ast.expr.Expression;");
		addStatement("import com.github.javaparser.StaticJavaParser;");
		
		addStatement("public class " + pqlProgramClassName + " implements IPQLProgram {");

		addStatement("public " + pqlProgramClassName + "() {}");
		
		String mainInvoker = String.join(NL, 
				"public static void main(String[] args) throws Exception {",
				"String sourceToExamine = args[0];",
				"String targetForModifications = args[1];",
				"String sourceTypeSolverPaths = args[2];",
				"String jarTypeSolverFiles = args[3];",
				pqlProgramClassName + " pg = new " + pqlProgramClassName + "();",
				"pg.run(sourceToExamine, targetForModifications, sourceTypeSolverPaths, jarTypeSolverFiles);",
				"}"
				);
		
		addStatement(mainInvoker);
		
	}
	
	private String getVariableName(String baseName) {
		return baseName.concat(Integer.toString(++lastVariableNameIndex));
	}

	private void pushFragment(FragmentOptionsContext fragmentOptions) {
		fragmentStack.push(getVariableName("fragment"));
		addStatement("FragmentPattern " + fragmentStack.peek() + " = new FragmentPattern();");
		DuplicatePolicy duplicatePolicy = DuplicatePolicy.valueOf(fragmentOptions.duplicatePolicy().getText());
		SearchPolicy childSearchPolicy = SearchPolicy.valueOf(fragmentOptions.childSearchPolicy().getText());
		addStatement(fragmentStack.peek() + ".setDuplicatePolicy(" + duplicatePolicy.getClass().getName() + "." + duplicatePolicy + ");");
		addStatement(fragmentStack.peek() + ".setChildSearchPolicy(" + childSearchPolicy.getClass().getName() + "." + childSearchPolicy + ");");
	}

	private void pushRootFragment(RootFragmentOptionsContext fragmentOptions) {
		fragmentStack.push(getVariableName("fragment"));
		addStatement("FragmentPattern " + fragmentStack.peek() + " = new FragmentPattern();");
		SearchPolicy fragmentSearchPolicy = SearchPolicy.valueOf(fragmentOptions.fragmentSearchPolicy().getText());
		SearchPolicy childSearchPolicy = SearchPolicy.valueOf(fragmentOptions.childSearchPolicy().getText());
		addStatement(fragmentStack.peek() + ".setFragmentSearchPolicy(" + fragmentSearchPolicy.getClass().getName() + "." + fragmentSearchPolicy + ");");
		addStatement(fragmentStack.peek() + ".setChildSearchPolicy(" + childSearchPolicy.getClass().getName() + "." + childSearchPolicy + ");");
	}

	public String getPqlProgramClassName() {
		return pqlProgramClassName;
	}

	public void setPqlProgramClassName(String pqlProgramClassName) {
		this.pqlProgramClassName = pqlProgramClassName;
	}

	private StringBuilder sb = new StringBuilder();
	private static final String DQ = "\"";
	private static final String NL = System.lineSeparator();
	private static final String PE_VAR = "pe";
	private Stack<String> fragmentStack = new Stack<>();
	private int lastVariableNameIndex = -1;
	private String pqlProgramClassName = null;
	
}
