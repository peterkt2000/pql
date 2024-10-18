// Generated from PQL.g4 by ANTLR 4.7.1

    package mil.darpa.immortals.core.das.pql.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PQLParser}.
 */
public interface PQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PQLParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PQLParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PQLParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#rootFragment}.
	 * @param ctx the parse tree
	 */
	void enterRootFragment(PQLParser.RootFragmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#rootFragment}.
	 * @param ctx the parse tree
	 */
	void exitRootFragment(PQLParser.RootFragmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#codeOrFragmentPatterns}.
	 * @param ctx the parse tree
	 */
	void enterCodeOrFragmentPatterns(PQLParser.CodeOrFragmentPatternsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#codeOrFragmentPatterns}.
	 * @param ctx the parse tree
	 */
	void exitCodeOrFragmentPatterns(PQLParser.CodeOrFragmentPatternsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fragmentPattern}.
	 * @param ctx the parse tree
	 */
	void enterFragmentPattern(PQLParser.FragmentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fragmentPattern}.
	 * @param ctx the parse tree
	 */
	void exitFragmentPattern(PQLParser.FragmentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#codePattern}.
	 * @param ctx the parse tree
	 */
	void enterCodePattern(PQLParser.CodePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#codePattern}.
	 * @param ctx the parse tree
	 */
	void exitCodePattern(PQLParser.CodePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(PQLParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(PQLParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(PQLParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(PQLParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(PQLParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(PQLParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#interfaceTypes}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypes(PQLParser.InterfaceTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#interfaceTypes}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypes(PQLParser.InterfaceTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#superClassType}.
	 * @param ctx the parse tree
	 */
	void enterSuperClassType(PQLParser.SuperClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#superClassType}.
	 * @param ctx the parse tree
	 */
	void exitSuperClassType(PQLParser.SuperClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#receiverType}.
	 * @param ctx the parse tree
	 */
	void enterReceiverType(PQLParser.ReceiverTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#receiverType}.
	 * @param ctx the parse tree
	 */
	void exitReceiverType(PQLParser.ReceiverTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(PQLParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(PQLParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(PQLParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(PQLParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#argumentTypes}.
	 * @param ctx the parse tree
	 */
	void enterArgumentTypes(PQLParser.ArgumentTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#argumentTypes}.
	 * @param ctx the parse tree
	 */
	void exitArgumentTypes(PQLParser.ArgumentTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameterTypes}.
	 * @param ctx the parse tree
	 */
	void enterParameterTypes(PQLParser.ParameterTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameterTypes}.
	 * @param ctx the parse tree
	 */
	void exitParameterTypes(PQLParser.ParameterTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#throwsTypes}.
	 * @param ctx the parse tree
	 */
	void enterThrowsTypes(PQLParser.ThrowsTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#throwsTypes}.
	 * @param ctx the parse tree
	 */
	void exitThrowsTypes(PQLParser.ThrowsTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#rootFragmentOptions}.
	 * @param ctx the parse tree
	 */
	void enterRootFragmentOptions(PQLParser.RootFragmentOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#rootFragmentOptions}.
	 * @param ctx the parse tree
	 */
	void exitRootFragmentOptions(PQLParser.RootFragmentOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fragmentOptions}.
	 * @param ctx the parse tree
	 */
	void enterFragmentOptions(PQLParser.FragmentOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fragmentOptions}.
	 * @param ctx the parse tree
	 */
	void exitFragmentOptions(PQLParser.FragmentOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#childSearchPolicy}.
	 * @param ctx the parse tree
	 */
	void enterChildSearchPolicy(PQLParser.ChildSearchPolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#childSearchPolicy}.
	 * @param ctx the parse tree
	 */
	void exitChildSearchPolicy(PQLParser.ChildSearchPolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fragmentSearchPolicy}.
	 * @param ctx the parse tree
	 */
	void enterFragmentSearchPolicy(PQLParser.FragmentSearchPolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fragmentSearchPolicy}.
	 * @param ctx the parse tree
	 */
	void exitFragmentSearchPolicy(PQLParser.FragmentSearchPolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#duplicatePolicy}.
	 * @param ctx the parse tree
	 */
	void enterDuplicatePolicy(PQLParser.DuplicatePolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#duplicatePolicy}.
	 * @param ctx the parse tree
	 */
	void exitDuplicatePolicy(PQLParser.DuplicatePolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(PQLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(PQLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#genericizedType}.
	 * @param ctx the parse tree
	 */
	void enterGenericizedType(PQLParser.GenericizedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#genericizedType}.
	 * @param ctx the parse tree
	 */
	void exitGenericizedType(PQLParser.GenericizedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#referenceSearch}.
	 * @param ctx the parse tree
	 */
	void enterReferenceSearch(PQLParser.ReferenceSearchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#referenceSearch}.
	 * @param ctx the parse tree
	 */
	void exitReferenceSearch(PQLParser.ReferenceSearchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#anchor}.
	 * @param ctx the parse tree
	 */
	void enterAnchor(PQLParser.AnchorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#anchor}.
	 * @param ctx the parse tree
	 */
	void exitAnchor(PQLParser.AnchorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(PQLParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(PQLParser.CommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addMethodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterAddMethodInvocation(PQLParser.AddMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addMethodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitAddMethodInvocation(PQLParser.AddMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addGetterSetter}.
	 * @param ctx the parse tree
	 */
	void enterAddGetterSetter(PQLParser.AddGetterSetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addGetterSetter}.
	 * @param ctx the parse tree
	 */
	void exitAddGetterSetter(PQLParser.AddGetterSetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addParameters}.
	 * @param ctx the parse tree
	 */
	void enterAddParameters(PQLParser.AddParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addParameters}.
	 * @param ctx the parse tree
	 */
	void exitAddParameters(PQLParser.AddParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#replace}.
	 * @param ctx the parse tree
	 */
	void enterReplace(PQLParser.ReplaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#replace}.
	 * @param ctx the parse tree
	 */
	void exitReplace(PQLParser.ReplaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(PQLParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(PQLParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addMethod}.
	 * @param ctx the parse tree
	 */
	void enterAddMethod(PQLParser.AddMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addMethod}.
	 * @param ctx the parse tree
	 */
	void exitAddMethod(PQLParser.AddMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addImports}.
	 * @param ctx the parse tree
	 */
	void enterAddImports(PQLParser.AddImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addImports}.
	 * @param ctx the parse tree
	 */
	void exitAddImports(PQLParser.AddImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addFields}.
	 * @param ctx the parse tree
	 */
	void enterAddFields(PQLParser.AddFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addFields}.
	 * @param ctx the parse tree
	 */
	void exitAddFields(PQLParser.AddFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#desugarMethodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterDesugarMethodInvocation(PQLParser.DesugarMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#desugarMethodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitDesugarMethodInvocation(PQLParser.DesugarMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#printMatch}.
	 * @param ctx the parse tree
	 */
	void enterPrintMatch(PQLParser.PrintMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#printMatch}.
	 * @param ctx the parse tree
	 */
	void exitPrintMatch(PQLParser.PrintMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(PQLParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(PQLParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PQLParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PQLParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(PQLParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(PQLParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PQLParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PQLParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PQLParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PQLParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PQLParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PQLParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(PQLParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(PQLParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameterPosition}.
	 * @param ctx the parse tree
	 */
	void enterParameterPosition(PQLParser.ParameterPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameterPosition}.
	 * @param ctx the parse tree
	 */
	void exitParameterPosition(PQLParser.ParameterPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(PQLParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(PQLParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(PQLParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(PQLParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(PQLParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(PQLParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(PQLParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(PQLParser.FieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#importType}.
	 * @param ctx the parse tree
	 */
	void enterImportType(PQLParser.ImportTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#importType}.
	 * @param ctx the parse tree
	 */
	void exitImportType(PQLParser.ImportTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#idempotent}.
	 * @param ctx the parse tree
	 */
	void enterIdempotent(PQLParser.IdempotentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#idempotent}.
	 * @param ctx the parse tree
	 */
	void exitIdempotent(PQLParser.IdempotentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(PQLParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(PQLParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#getterAccessModifier}.
	 * @param ctx the parse tree
	 */
	void enterGetterAccessModifier(PQLParser.GetterAccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#getterAccessModifier}.
	 * @param ctx the parse tree
	 */
	void exitGetterAccessModifier(PQLParser.GetterAccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#setterAccessModifier}.
	 * @param ctx the parse tree
	 */
	void enterSetterAccessModifier(PQLParser.SetterAccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#setterAccessModifier}.
	 * @param ctx the parse tree
	 */
	void exitSetterAccessModifier(PQLParser.SetterAccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(PQLParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(PQLParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(PQLParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(PQLParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(PQLParser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(PQLParser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#methodToInvoke}.
	 * @param ctx the parse tree
	 */
	void enterMethodToInvoke(PQLParser.MethodToInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#methodToInvoke}.
	 * @param ctx the parse tree
	 */
	void exitMethodToInvoke(PQLParser.MethodToInvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#pqlExpression}.
	 * @param ctx the parse tree
	 */
	void enterPqlExpression(PQLParser.PqlExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#pqlExpression}.
	 * @param ctx the parse tree
	 */
	void exitPqlExpression(PQLParser.PqlExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#contextReferences}.
	 * @param ctx the parse tree
	 */
	void enterContextReferences(PQLParser.ContextReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#contextReferences}.
	 * @param ctx the parse tree
	 */
	void exitContextReferences(PQLParser.ContextReferencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#stringContextReference}.
	 * @param ctx the parse tree
	 */
	void enterStringContextReference(PQLParser.StringContextReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#stringContextReference}.
	 * @param ctx the parse tree
	 */
	void exitStringContextReference(PQLParser.StringContextReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#stringArrayContextReference}.
	 * @param ctx the parse tree
	 */
	void enterStringArrayContextReference(PQLParser.StringArrayContextReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#stringArrayContextReference}.
	 * @param ctx the parse tree
	 */
	void exitStringArrayContextReference(PQLParser.StringArrayContextReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#nameExpression}.
	 * @param ctx the parse tree
	 */
	void enterNameExpression(PQLParser.NameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#nameExpression}.
	 * @param ctx the parse tree
	 */
	void exitNameExpression(PQLParser.NameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#bindingLookup}.
	 * @param ctx the parse tree
	 */
	void enterBindingLookup(PQLParser.BindingLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#bindingLookup}.
	 * @param ctx the parse tree
	 */
	void exitBindingLookup(PQLParser.BindingLookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#lookupIndex}.
	 * @param ctx the parse tree
	 */
	void enterLookupIndex(PQLParser.LookupIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#lookupIndex}.
	 * @param ctx the parse tree
	 */
	void exitLookupIndex(PQLParser.LookupIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addition_subtraction}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition_subtraction(PQLParser.Addition_subtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addition_subtraction}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition_subtraction(PQLParser.Addition_subtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_reference}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray_reference(PQLParser.Array_referenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_reference}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray_reference(PQLParser.Array_referenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegation(PQLParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegation(PQLParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesized_expr}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesized_expr(PQLParser.Parenthesized_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesized_expr}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesized_expr(PQLParser.Parenthesized_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(PQLParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(PQLParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNull(PQLParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNull(PQLParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function_call}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(PQLParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function_call}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(PQLParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary_minus}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_minus(PQLParser.Unary_minusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary_minus}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_minus(PQLParser.Unary_minusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(PQLParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(PQLParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(PQLParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(PQLParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(PQLParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(PQLParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equality}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality(PQLParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link PQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality(PQLParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(PQLParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(PQLParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addGetter}.
	 * @param ctx the parse tree
	 */
	void enterAddGetter(PQLParser.AddGetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addGetter}.
	 * @param ctx the parse tree
	 */
	void exitAddGetter(PQLParser.AddGetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#addSetter}.
	 * @param ctx the parse tree
	 */
	void enterAddSetter(PQLParser.AddSetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#addSetter}.
	 * @param ctx the parse tree
	 */
	void exitAddSetter(PQLParser.AddSetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PQLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PQLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(PQLParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(PQLParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(PQLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(PQLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#applyToAncestorClass}.
	 * @param ctx the parse tree
	 */
	void enterApplyToAncestorClass(PQLParser.ApplyToAncestorClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#applyToAncestorClass}.
	 * @param ctx the parse tree
	 */
	void exitApplyToAncestorClass(PQLParser.ApplyToAncestorClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#staticModifier}.
	 * @param ctx the parse tree
	 */
	void enterStaticModifier(PQLParser.StaticModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#staticModifier}.
	 * @param ctx the parse tree
	 */
	void exitStaticModifier(PQLParser.StaticModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#finalModifier}.
	 * @param ctx the parse tree
	 */
	void enterFinalModifier(PQLParser.FinalModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#finalModifier}.
	 * @param ctx the parse tree
	 */
	void exitFinalModifier(PQLParser.FinalModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#abstractModifier}.
	 * @param ctx the parse tree
	 */
	void enterAbstractModifier(PQLParser.AbstractModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#abstractModifier}.
	 * @param ctx the parse tree
	 */
	void exitAbstractModifier(PQLParser.AbstractModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#nestedClass}.
	 * @param ctx the parse tree
	 */
	void enterNestedClass(PQLParser.NestedClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#nestedClass}.
	 * @param ctx the parse tree
	 */
	void exitNestedClass(PQLParser.NestedClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#nativeModifier}.
	 * @param ctx the parse tree
	 */
	void enterNativeModifier(PQLParser.NativeModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#nativeModifier}.
	 * @param ctx the parse tree
	 */
	void exitNativeModifier(PQLParser.NativeModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#synchronizedModifier}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedModifier(PQLParser.SynchronizedModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#synchronizedModifier}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedModifier(PQLParser.SynchronizedModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(PQLParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(PQLParser.OrderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#bindingRef}.
	 * @param ctx the parse tree
	 */
	void enterBindingRef(PQLParser.BindingRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#bindingRef}.
	 * @param ctx the parse tree
	 */
	void exitBindingRef(PQLParser.BindingRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#bindingDecl}.
	 * @param ctx the parse tree
	 */
	void enterBindingDecl(PQLParser.BindingDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#bindingDecl}.
	 * @param ctx the parse tree
	 */
	void exitBindingDecl(PQLParser.BindingDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#targetBinding}.
	 * @param ctx the parse tree
	 */
	void enterTargetBinding(PQLParser.TargetBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#targetBinding}.
	 * @param ctx the parse tree
	 */
	void exitTargetBinding(PQLParser.TargetBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#searchPolicy}.
	 * @param ctx the parse tree
	 */
	void enterSearchPolicy(PQLParser.SearchPolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#searchPolicy}.
	 * @param ctx the parse tree
	 */
	void exitSearchPolicy(PQLParser.SearchPolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PQLParser#patternContext}.
	 * @param ctx the parse tree
	 */
	void enterPatternContext(PQLParser.PatternContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQLParser#patternContext}.
	 * @param ctx the parse tree
	 */
	void exitPatternContext(PQLParser.PatternContextContext ctx);
}