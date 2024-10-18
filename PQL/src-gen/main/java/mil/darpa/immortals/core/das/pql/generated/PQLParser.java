// Generated from PQL.g4 by ANTLR 4.7.1

    package mil.darpa.immortals.core.das.pql.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, RECEIVER=29, ADD_METHOD_INVOCATION=30, 
		ARGUMENTS=31, FIELD_TYPE=32, ADD_GETTER_SETTER=33, FIELD_NAME=34, ADD_GETTER=35, 
		ADD_SETTER=36, GETTER_ACCESS_MODIFIER=37, SETTER_ACCESS_MODIFIER=38, APPLY_TO_ANCESTOR_CLASS=39, 
		INITIALIZER=40, IDEMPOTENT=41, WHEN=42, FRAGMENT=43, THEN=44, STRINGENT=45, 
		LENIENT=46, ORDERED=47, UNORDERED=48, REFERENCE=49, REFERENCE_SEARCH=50, 
		REPLACE=51, ADD_PARAMETERS=52, ADD_METHOD=53, ADD_IMPORTS=54, ADD_FIELDS=55, 
		DESUGAR_METHOD_INVOCATION=56, PRINT_MATCH=57, METHOD_INVOCATION=58, METHOD_DECLARATION=59, 
		CLASS_DECLARATION=60, ACCESS_MODIFIER=61, RECEIVER_TYPE=62, RETURN_TYPE=63, 
		TYPE=64, METHOD_NAME=65, NAME=66, ADD_AFTER_POSITION=67, TARGET_ID=68, 
		PATTERN_CONTEXT=69, ARGUMENT_TYPES=70, PARAMETER_TYPES=71, THROWS_TYPES=72, 
		ID=73, FRAGMENT_SEARCH_POLICY=74, CHILD_SEARCH_POLICY=75, DUPLICATE_POLICY=76, 
		SUPERCLASS_TYPE=77, INTERFACE_TYPES=78, RESTART_AT_HOME=79, RESTART_AT_END_LAST_MATCH=80, 
		EXPRESSION=81, STATEMENT=82, STATIC_MODIFIER=83, FINAL_MODIFIER=84, ABSTRACT_MODIFIER=85, 
		NESTED_CLASS=86, NATIVE_MODIFIER=87, SYNCHRONIZED_MODIFIER=88, HALT_ON_DUPLICATE=89, 
		SEARCH_NEXT_UNIQUE=90, CYCLE_CHILDREN=91, CODE_BLOCK=92, BINDING_REF=93, 
		WS=94, COMMENT=95, LINE_COMMENT=96, BOOL_LITERAL=97, IDENTIFIER=98, INT_LITERAL=99, 
		DECIMAL_LITERAL=100, STRING_LITERAL=101;
	public static final int
		RULE_prog = 0, RULE_rootFragment = 1, RULE_codeOrFragmentPatterns = 2, 
		RULE_fragmentPattern = 3, RULE_codePattern = 4, RULE_methodInvocation = 5, 
		RULE_methodDeclaration = 6, RULE_classDeclaration = 7, RULE_interfaceTypes = 8, 
		RULE_superClassType = 9, RULE_receiverType = 10, RULE_returnType = 11, 
		RULE_methodName = 12, RULE_argumentTypes = 13, RULE_parameterTypes = 14, 
		RULE_throwsTypes = 15, RULE_rootFragmentOptions = 16, RULE_fragmentOptions = 17, 
		RULE_childSearchPolicy = 18, RULE_fragmentSearchPolicy = 19, RULE_duplicatePolicy = 20, 
		RULE_reference = 21, RULE_type = 22, RULE_genericizedType = 23, RULE_referenceSearch = 24, 
		RULE_anchor = 25, RULE_commands = 26, RULE_addMethodInvocation = 27, RULE_addGetterSetter = 28, 
		RULE_addParameters = 29, RULE_replace = 30, RULE_codeBlock = 31, RULE_addMethod = 32, 
		RULE_addImports = 33, RULE_addFields = 34, RULE_desugarMethodInvocation = 35, 
		RULE_printMatch = 36, RULE_fields = 37, RULE_field = 38, RULE_imports = 39, 
		RULE_arguments = 40, RULE_argument = 41, RULE_parameters = 42, RULE_parameter = 43, 
		RULE_parameterPosition = 44, RULE_parameterType = 45, RULE_parameterName = 46, 
		RULE_fieldName = 47, RULE_fieldType = 48, RULE_importType = 49, RULE_idempotent = 50, 
		RULE_accessModifier = 51, RULE_getterAccessModifier = 52, RULE_setterAccessModifier = 53, 
		RULE_scope = 54, RULE_initializer = 55, RULE_receiver = 56, RULE_methodToInvoke = 57, 
		RULE_pqlExpression = 58, RULE_contextReferences = 59, RULE_stringContextReference = 60, 
		RULE_stringArrayContextReference = 61, RULE_nameExpression = 62, RULE_bindingLookup = 63, 
		RULE_lookupIndex = 64, RULE_expression = 65, RULE_expressions = 66, RULE_addGetter = 67, 
		RULE_addSetter = 68, RULE_stringLiteral = 69, RULE_decimalLiteral = 70, 
		RULE_booleanLiteral = 71, RULE_applyToAncestorClass = 72, RULE_staticModifier = 73, 
		RULE_finalModifier = 74, RULE_abstractModifier = 75, RULE_nestedClass = 76, 
		RULE_nativeModifier = 77, RULE_synchronizedModifier = 78, RULE_order = 79, 
		RULE_bindingRef = 80, RULE_bindingDecl = 81, RULE_targetBinding = 82, 
		RULE_searchPolicy = 83, RULE_patternContext = 84;
	public static final String[] ruleNames = {
		"prog", "rootFragment", "codeOrFragmentPatterns", "fragmentPattern", "codePattern", 
		"methodInvocation", "methodDeclaration", "classDeclaration", "interfaceTypes", 
		"superClassType", "receiverType", "returnType", "methodName", "argumentTypes", 
		"parameterTypes", "throwsTypes", "rootFragmentOptions", "fragmentOptions", 
		"childSearchPolicy", "fragmentSearchPolicy", "duplicatePolicy", "reference", 
		"type", "genericizedType", "referenceSearch", "anchor", "commands", "addMethodInvocation", 
		"addGetterSetter", "addParameters", "replace", "codeBlock", "addMethod", 
		"addImports", "addFields", "desugarMethodInvocation", "printMatch", "fields", 
		"field", "imports", "arguments", "argument", "parameters", "parameter", 
		"parameterPosition", "parameterType", "parameterName", "fieldName", "fieldType", 
		"importType", "idempotent", "accessModifier", "getterAccessModifier", 
		"setterAccessModifier", "scope", "initializer", "receiver", "methodToInvoke", 
		"pqlExpression", "contextReferences", "stringContextReference", "stringArrayContextReference", 
		"nameExpression", "bindingLookup", "lookupIndex", "expression", "expressions", 
		"addGetter", "addSetter", "stringLiteral", "decimalLiteral", "booleanLiteral", 
		"applyToAncestorClass", "staticModifier", "finalModifier", "abstractModifier", 
		"nestedClass", "nativeModifier", "synchronizedModifier", "order", "bindingRef", 
		"bindingDecl", "targetBinding", "searchPolicy", "patternContext"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "':'", "','", "')'", "';'", "'.'", "'<'", "'>'", 
		"'()'", "'*'", "'Public'", "'Private'", "'Protected'", "'PackageLevel'", 
		"'`'", "'Context'", "'getString'", "'getStringArray'", "'['", "']'", "'null'", 
		"'this'", "'-'", "'!'", "'+'", "'=='", "'Receiver'", "'addMethodInvocation'", 
		"'Arguments'", "'FieldType'", "'addGetterSetter'", "'FieldName'", "'AddGetter'", 
		"'AddSetter'", "'GetterAccessModifier'", "'SetterAccessModifier'", "'ApplyToAncestorClass'", 
		"'Initializer'", "'Idempotent'", "'when'", "'fragment'", "'then'", "'stringent'", 
		"'lenient'", "'ordered'", "'unordered'", "'reference'", "'referenceSearch'", 
		"'replace'", "'addParameters'", "'addMethod'", "'addImports'", "'addFields'", 
		"'desugarMethodInvocation'", "'printMatch'", "'methodInvocation'", "'methodDeclaration'", 
		"'classDeclaration'", "'AccessModifier'", "'ReceiverType'", "'ReturnType'", 
		"'Type'", "'MethodName'", "'Name'", "'AddAfterPosition'", "'TargetID'", 
		"'PatternContext'", "'ArgumentTypes'", "'ParameterTypes'", "'ThrowsTypes'", 
		"'ID'", "'FragmentSearchPolicy'", "'ChildSearchPolicy'", "'DuplicatePolicy'", 
		"'SuperClassType'", "'InterfaceTypes'", "'RestartAtHome'", "'RestartAtEndLastMatch'", 
		"'Expression'", "'Statement'", "'StaticModifier'", "'FinalModifier'", 
		"'AbstractModifier'", "'Nested'", "'NativeModifier'", "'SynchronizedModifier'", 
		"'HaltOnDuplicate'", "'SearchNextUnique'", "'CycleChildren'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "RECEIVER", "ADD_METHOD_INVOCATION", "ARGUMENTS", 
		"FIELD_TYPE", "ADD_GETTER_SETTER", "FIELD_NAME", "ADD_GETTER", "ADD_SETTER", 
		"GETTER_ACCESS_MODIFIER", "SETTER_ACCESS_MODIFIER", "APPLY_TO_ANCESTOR_CLASS", 
		"INITIALIZER", "IDEMPOTENT", "WHEN", "FRAGMENT", "THEN", "STRINGENT", 
		"LENIENT", "ORDERED", "UNORDERED", "REFERENCE", "REFERENCE_SEARCH", "REPLACE", 
		"ADD_PARAMETERS", "ADD_METHOD", "ADD_IMPORTS", "ADD_FIELDS", "DESUGAR_METHOD_INVOCATION", 
		"PRINT_MATCH", "METHOD_INVOCATION", "METHOD_DECLARATION", "CLASS_DECLARATION", 
		"ACCESS_MODIFIER", "RECEIVER_TYPE", "RETURN_TYPE", "TYPE", "METHOD_NAME", 
		"NAME", "ADD_AFTER_POSITION", "TARGET_ID", "PATTERN_CONTEXT", "ARGUMENT_TYPES", 
		"PARAMETER_TYPES", "THROWS_TYPES", "ID", "FRAGMENT_SEARCH_POLICY", "CHILD_SEARCH_POLICY", 
		"DUPLICATE_POLICY", "SUPERCLASS_TYPE", "INTERFACE_TYPES", "RESTART_AT_HOME", 
		"RESTART_AT_END_LAST_MATCH", "EXPRESSION", "STATEMENT", "STATIC_MODIFIER", 
		"FINAL_MODIFIER", "ABSTRACT_MODIFIER", "NESTED_CLASS", "NATIVE_MODIFIER", 
		"SYNCHRONIZED_MODIFIER", "HALT_ON_DUPLICATE", "SEARCH_NEXT_UNIQUE", "CYCLE_CHILDREN", 
		"CODE_BLOCK", "BINDING_REF", "WS", "COMMENT", "LINE_COMMENT", "BOOL_LITERAL", 
		"IDENTIFIER", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(PQLParser.WHEN, 0); }
		public RootFragmentContext rootFragment() {
			return getRuleContext(RootFragmentContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PQLParser.THEN, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(WHEN);
			setState(171);
			match(T__0);
			setState(172);
			rootFragment();
			setState(173);
			match(T__1);
			setState(174);
			match(THEN);
			setState(175);
			match(T__0);
			setState(176);
			commands();
			setState(177);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootFragmentContext extends ParserRuleContext {
		public TerminalNode FRAGMENT() { return getToken(PQLParser.FRAGMENT, 0); }
		public RootFragmentOptionsContext rootFragmentOptions() {
			return getRuleContext(RootFragmentOptionsContext.class,0);
		}
		public CodeOrFragmentPatternsContext codeOrFragmentPatterns() {
			return getRuleContext(CodeOrFragmentPatternsContext.class,0);
		}
		public RootFragmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootFragment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterRootFragment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitRootFragment(this);
		}
	}

	public final RootFragmentContext rootFragment() throws RecognitionException {
		RootFragmentContext _localctx = new RootFragmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rootFragment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(FRAGMENT);
			setState(180);
			rootFragmentOptions();
			setState(181);
			match(T__0);
			setState(182);
			codeOrFragmentPatterns();
			setState(183);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeOrFragmentPatternsContext extends ParserRuleContext {
		public List<FragmentPatternContext> fragmentPattern() {
			return getRuleContexts(FragmentPatternContext.class);
		}
		public FragmentPatternContext fragmentPattern(int i) {
			return getRuleContext(FragmentPatternContext.class,i);
		}
		public List<CodePatternContext> codePattern() {
			return getRuleContexts(CodePatternContext.class);
		}
		public CodePatternContext codePattern(int i) {
			return getRuleContext(CodePatternContext.class,i);
		}
		public CodeOrFragmentPatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeOrFragmentPatterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterCodeOrFragmentPatterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitCodeOrFragmentPatterns(this);
		}
	}

	public final CodeOrFragmentPatternsContext codeOrFragmentPatterns() throws RecognitionException {
		CodeOrFragmentPatternsContext _localctx = new CodeOrFragmentPatternsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_codeOrFragmentPatterns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FRAGMENT:
					{
					setState(185);
					fragmentPattern();
					}
					break;
				case REFERENCE_SEARCH:
				case METHOD_INVOCATION:
				case METHOD_DECLARATION:
				case CLASS_DECLARATION:
					{
					setState(186);
					codePattern();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FRAGMENT) | (1L << REFERENCE_SEARCH) | (1L << METHOD_INVOCATION) | (1L << METHOD_DECLARATION) | (1L << CLASS_DECLARATION))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentPatternContext extends ParserRuleContext {
		public TerminalNode FRAGMENT() { return getToken(PQLParser.FRAGMENT, 0); }
		public FragmentOptionsContext fragmentOptions() {
			return getRuleContext(FragmentOptionsContext.class,0);
		}
		public CodeOrFragmentPatternsContext codeOrFragmentPatterns() {
			return getRuleContext(CodeOrFragmentPatternsContext.class,0);
		}
		public FragmentPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFragmentPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFragmentPattern(this);
		}
	}

	public final FragmentPatternContext fragmentPattern() throws RecognitionException {
		FragmentPatternContext _localctx = new FragmentPatternContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fragmentPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(FRAGMENT);
			setState(192);
			fragmentOptions();
			setState(193);
			match(T__0);
			setState(194);
			codeOrFragmentPatterns();
			setState(195);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodePatternContext extends ParserRuleContext {
		public ReferenceSearchContext referenceSearch() {
			return getRuleContext(ReferenceSearchContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public CodePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterCodePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitCodePattern(this);
		}
	}

	public final CodePatternContext codePattern() throws RecognitionException {
		CodePatternContext _localctx = new CodePatternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codePattern);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REFERENCE_SEARCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				referenceSearch();
				}
				break;
			case METHOD_INVOCATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				methodInvocation();
				}
				break;
			case CLASS_DECLARATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				classDeclaration();
				}
				break;
			case METHOD_DECLARATION:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				methodDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationContext extends ParserRuleContext {
		public TerminalNode METHOD_INVOCATION() { return getToken(PQLParser.METHOD_INVOCATION, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode RECEIVER_TYPE() { return getToken(PQLParser.RECEIVER_TYPE, 0); }
		public ReceiverTypeContext receiverType() {
			return getRuleContext(ReceiverTypeContext.class,0);
		}
		public TerminalNode METHOD_NAME() { return getToken(PQLParser.METHOD_NAME, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode PATTERN_CONTEXT() { return getToken(PQLParser.PATTERN_CONTEXT, 0); }
		public PatternContextContext patternContext() {
			return getRuleContext(PatternContextContext.class,0);
		}
		public TerminalNode ARGUMENT_TYPES() { return getToken(PQLParser.ARGUMENT_TYPES, 0); }
		public ArgumentTypesContext argumentTypes() {
			return getRuleContext(ArgumentTypesContext.class,0);
		}
		public TerminalNode DUPLICATE_POLICY() { return getToken(PQLParser.DUPLICATE_POLICY, 0); }
		public DuplicatePolicyContext duplicatePolicy() {
			return getRuleContext(DuplicatePolicyContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitMethodInvocation(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(METHOD_INVOCATION);
			setState(204);
			match(T__2);
			setState(205);
			match(ID);
			setState(206);
			match(T__3);
			setState(207);
			bindingDecl();
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(208);
				match(T__4);
				setState(209);
				match(RECEIVER_TYPE);
				setState(210);
				match(T__3);
				setState(211);
				receiverType();
				}
				break;
			}
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(214);
				match(T__4);
				setState(215);
				match(METHOD_NAME);
				setState(216);
				match(T__3);
				setState(217);
				methodName();
				}
				break;
			}
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(220);
				match(T__4);
				setState(221);
				match(PATTERN_CONTEXT);
				setState(222);
				match(T__3);
				setState(223);
				patternContext();
				}
				break;
			}
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(226);
				match(T__4);
				setState(227);
				match(ARGUMENT_TYPES);
				setState(228);
				match(T__3);
				setState(229);
				match(T__2);
				setState(230);
				argumentTypes();
				setState(231);
				match(T__5);
				}
				break;
			}
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(235);
				match(T__4);
				setState(236);
				match(DUPLICATE_POLICY);
				setState(237);
				match(T__3);
				setState(238);
				duplicatePolicy();
				}
			}

			setState(241);
			match(T__5);
			setState(242);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode METHOD_DECLARATION() { return getToken(PQLParser.METHOD_DECLARATION, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode ACCESS_MODIFIER() { return getToken(PQLParser.ACCESS_MODIFIER, 0); }
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public TerminalNode STATIC_MODIFIER() { return getToken(PQLParser.STATIC_MODIFIER, 0); }
		public StaticModifierContext staticModifier() {
			return getRuleContext(StaticModifierContext.class,0);
		}
		public TerminalNode ABSTRACT_MODIFIER() { return getToken(PQLParser.ABSTRACT_MODIFIER, 0); }
		public AbstractModifierContext abstractModifier() {
			return getRuleContext(AbstractModifierContext.class,0);
		}
		public TerminalNode FINAL_MODIFIER() { return getToken(PQLParser.FINAL_MODIFIER, 0); }
		public FinalModifierContext finalModifier() {
			return getRuleContext(FinalModifierContext.class,0);
		}
		public TerminalNode NATIVE_MODIFIER() { return getToken(PQLParser.NATIVE_MODIFIER, 0); }
		public NativeModifierContext nativeModifier() {
			return getRuleContext(NativeModifierContext.class,0);
		}
		public TerminalNode SYNCHRONIZED_MODIFIER() { return getToken(PQLParser.SYNCHRONIZED_MODIFIER, 0); }
		public SynchronizedModifierContext synchronizedModifier() {
			return getRuleContext(SynchronizedModifierContext.class,0);
		}
		public TerminalNode RETURN_TYPE() { return getToken(PQLParser.RETURN_TYPE, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode METHOD_NAME() { return getToken(PQLParser.METHOD_NAME, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode PARAMETER_TYPES() { return getToken(PQLParser.PARAMETER_TYPES, 0); }
		public ParameterTypesContext parameterTypes() {
			return getRuleContext(ParameterTypesContext.class,0);
		}
		public TerminalNode THROWS_TYPES() { return getToken(PQLParser.THROWS_TYPES, 0); }
		public ThrowsTypesContext throwsTypes() {
			return getRuleContext(ThrowsTypesContext.class,0);
		}
		public TerminalNode CHILD_SEARCH_POLICY() { return getToken(PQLParser.CHILD_SEARCH_POLICY, 0); }
		public ChildSearchPolicyContext childSearchPolicy() {
			return getRuleContext(ChildSearchPolicyContext.class,0);
		}
		public TerminalNode DUPLICATE_POLICY() { return getToken(PQLParser.DUPLICATE_POLICY, 0); }
		public DuplicatePolicyContext duplicatePolicy() {
			return getRuleContext(DuplicatePolicyContext.class,0);
		}
		public CodeOrFragmentPatternsContext codeOrFragmentPatterns() {
			return getRuleContext(CodeOrFragmentPatternsContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(METHOD_DECLARATION);
			setState(245);
			match(T__2);
			setState(246);
			match(ID);
			setState(247);
			match(T__3);
			setState(248);
			bindingDecl();
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(249);
				match(T__4);
				setState(250);
				match(ACCESS_MODIFIER);
				setState(251);
				match(T__3);
				setState(252);
				accessModifier();
				}
				break;
			}
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(255);
				match(T__4);
				setState(256);
				match(STATIC_MODIFIER);
				setState(257);
				match(T__3);
				setState(258);
				staticModifier();
				}
				break;
			}
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(261);
				match(T__4);
				setState(262);
				match(ABSTRACT_MODIFIER);
				setState(263);
				match(T__3);
				setState(264);
				abstractModifier();
				}
				break;
			}
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(267);
				match(T__4);
				setState(268);
				match(FINAL_MODIFIER);
				setState(269);
				match(T__3);
				setState(270);
				finalModifier();
				}
				break;
			}
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(273);
				match(T__4);
				setState(274);
				match(NATIVE_MODIFIER);
				setState(275);
				match(T__3);
				setState(276);
				nativeModifier();
				}
				break;
			}
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(279);
				match(T__4);
				setState(280);
				match(SYNCHRONIZED_MODIFIER);
				setState(281);
				match(T__3);
				setState(282);
				synchronizedModifier();
				}
				break;
			}
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(285);
				match(T__4);
				setState(286);
				match(RETURN_TYPE);
				setState(287);
				match(T__3);
				setState(288);
				returnType();
				}
				break;
			}
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(291);
				match(T__4);
				setState(292);
				match(METHOD_NAME);
				setState(293);
				match(T__3);
				setState(294);
				methodName();
				}
				break;
			}
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(297);
				match(T__4);
				setState(298);
				match(PARAMETER_TYPES);
				setState(299);
				match(T__3);
				setState(300);
				match(T__2);
				setState(301);
				parameterTypes();
				setState(302);
				match(T__5);
				}
				break;
			}
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(306);
				match(T__4);
				setState(307);
				match(THROWS_TYPES);
				setState(308);
				match(T__3);
				setState(309);
				match(T__2);
				setState(310);
				throwsTypes();
				setState(311);
				match(T__5);
				}
				break;
			}
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(315);
				match(T__4);
				setState(316);
				match(CHILD_SEARCH_POLICY);
				setState(317);
				match(T__3);
				setState(318);
				childSearchPolicy();
				}
				break;
			}
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(321);
				match(T__4);
				setState(322);
				match(DUPLICATE_POLICY);
				setState(323);
				match(T__3);
				setState(324);
				duplicatePolicy();
				}
			}

			setState(327);
			match(T__5);
			setState(328);
			match(T__0);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FRAGMENT) | (1L << REFERENCE_SEARCH) | (1L << METHOD_INVOCATION) | (1L << METHOD_DECLARATION) | (1L << CLASS_DECLARATION))) != 0)) {
				{
				setState(329);
				codeOrFragmentPatterns();
				}
			}

			setState(332);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS_DECLARATION() { return getToken(PQLParser.CLASS_DECLARATION, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode ACCESS_MODIFIER() { return getToken(PQLParser.ACCESS_MODIFIER, 0); }
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public TerminalNode STATIC_MODIFIER() { return getToken(PQLParser.STATIC_MODIFIER, 0); }
		public StaticModifierContext staticModifier() {
			return getRuleContext(StaticModifierContext.class,0);
		}
		public TerminalNode ABSTRACT_MODIFIER() { return getToken(PQLParser.ABSTRACT_MODIFIER, 0); }
		public AbstractModifierContext abstractModifier() {
			return getRuleContext(AbstractModifierContext.class,0);
		}
		public TerminalNode FINAL_MODIFIER() { return getToken(PQLParser.FINAL_MODIFIER, 0); }
		public FinalModifierContext finalModifier() {
			return getRuleContext(FinalModifierContext.class,0);
		}
		public TerminalNode SUPERCLASS_TYPE() { return getToken(PQLParser.SUPERCLASS_TYPE, 0); }
		public SuperClassTypeContext superClassType() {
			return getRuleContext(SuperClassTypeContext.class,0);
		}
		public TerminalNode INTERFACE_TYPES() { return getToken(PQLParser.INTERFACE_TYPES, 0); }
		public InterfaceTypesContext interfaceTypes() {
			return getRuleContext(InterfaceTypesContext.class,0);
		}
		public TerminalNode NESTED_CLASS() { return getToken(PQLParser.NESTED_CLASS, 0); }
		public NestedClassContext nestedClass() {
			return getRuleContext(NestedClassContext.class,0);
		}
		public TerminalNode CHILD_SEARCH_POLICY() { return getToken(PQLParser.CHILD_SEARCH_POLICY, 0); }
		public ChildSearchPolicyContext childSearchPolicy() {
			return getRuleContext(ChildSearchPolicyContext.class,0);
		}
		public TerminalNode DUPLICATE_POLICY() { return getToken(PQLParser.DUPLICATE_POLICY, 0); }
		public DuplicatePolicyContext duplicatePolicy() {
			return getRuleContext(DuplicatePolicyContext.class,0);
		}
		public CodeOrFragmentPatternsContext codeOrFragmentPatterns() {
			return getRuleContext(CodeOrFragmentPatternsContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(CLASS_DECLARATION);
			setState(335);
			match(T__2);
			setState(336);
			match(ID);
			setState(337);
			match(T__3);
			setState(338);
			bindingDecl();
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(339);
				match(T__4);
				setState(340);
				match(ACCESS_MODIFIER);
				setState(341);
				match(T__3);
				setState(342);
				accessModifier();
				}
				break;
			}
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(345);
				match(T__4);
				setState(346);
				match(STATIC_MODIFIER);
				setState(347);
				match(T__3);
				setState(348);
				staticModifier();
				}
				break;
			}
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(351);
				match(T__4);
				setState(352);
				match(ABSTRACT_MODIFIER);
				setState(353);
				match(T__3);
				setState(354);
				abstractModifier();
				}
				break;
			}
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(357);
				match(T__4);
				setState(358);
				match(FINAL_MODIFIER);
				setState(359);
				match(T__3);
				setState(360);
				finalModifier();
				}
				break;
			}
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(363);
				match(T__4);
				setState(364);
				match(SUPERCLASS_TYPE);
				setState(365);
				match(T__3);
				setState(366);
				superClassType();
				}
				break;
			}
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(369);
				match(T__4);
				setState(370);
				match(INTERFACE_TYPES);
				setState(371);
				match(T__3);
				setState(372);
				match(T__2);
				setState(373);
				interfaceTypes();
				setState(374);
				match(T__5);
				}
				break;
			}
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(378);
				match(T__4);
				setState(379);
				match(NESTED_CLASS);
				setState(380);
				match(T__3);
				setState(381);
				nestedClass();
				}
				break;
			}
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(384);
				match(T__4);
				setState(385);
				match(CHILD_SEARCH_POLICY);
				setState(386);
				match(T__3);
				setState(387);
				childSearchPolicy();
				}
				break;
			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(390);
				match(T__4);
				setState(391);
				match(DUPLICATE_POLICY);
				setState(392);
				match(T__3);
				setState(393);
				duplicatePolicy();
				}
			}

			setState(396);
			match(T__5);
			setState(397);
			match(T__0);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FRAGMENT) | (1L << REFERENCE_SEARCH) | (1L << METHOD_INVOCATION) | (1L << METHOD_DECLARATION) | (1L << CLASS_DECLARATION))) != 0)) {
				{
				setState(398);
				codeOrFragmentPatterns();
				}
			}

			setState(401);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypesContext extends ParserRuleContext {
		public List<GenericizedTypeContext> genericizedType() {
			return getRuleContexts(GenericizedTypeContext.class);
		}
		public GenericizedTypeContext genericizedType(int i) {
			return getRuleContext(GenericizedTypeContext.class,i);
		}
		public InterfaceTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterInterfaceTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitInterfaceTypes(this);
		}
	}

	public final InterfaceTypesContext interfaceTypes() throws RecognitionException {
		InterfaceTypesContext _localctx = new InterfaceTypesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_interfaceTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			genericizedType();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(404);
				match(T__4);
				setState(405);
				genericizedType();
				}
				}
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperClassTypeContext extends ParserRuleContext {
		public GenericizedTypeContext genericizedType() {
			return getRuleContext(GenericizedTypeContext.class,0);
		}
		public SuperClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterSuperClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitSuperClassType(this);
		}
	}

	public final SuperClassTypeContext superClassType() throws RecognitionException {
		SuperClassTypeContext _localctx = new SuperClassTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_superClassType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			genericizedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverTypeContext extends ParserRuleContext {
		public GenericizedTypeContext genericizedType() {
			return getRuleContext(GenericizedTypeContext.class,0);
		}
		public ReceiverTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReceiverType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReceiverType(this);
		}
	}

	public final ReceiverTypeContext receiverType() throws RecognitionException {
		ReceiverTypeContext _localctx = new ReceiverTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_receiverType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			genericizedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public GenericizedTypeContext genericizedType() {
			return getRuleContext(GenericizedTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			genericizedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitMethodName(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentTypesContext extends ParserRuleContext {
		public List<GenericizedTypeContext> genericizedType() {
			return getRuleContexts(GenericizedTypeContext.class);
		}
		public GenericizedTypeContext genericizedType(int i) {
			return getRuleContext(GenericizedTypeContext.class,i);
		}
		public ArgumentTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterArgumentTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitArgumentTypes(this);
		}
	}

	public final ArgumentTypesContext argumentTypes() throws RecognitionException {
		ArgumentTypesContext _localctx = new ArgumentTypesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argumentTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			genericizedType();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(420);
				match(T__4);
				setState(421);
				genericizedType();
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterTypesContext extends ParserRuleContext {
		public List<GenericizedTypeContext> genericizedType() {
			return getRuleContexts(GenericizedTypeContext.class);
		}
		public GenericizedTypeContext genericizedType(int i) {
			return getRuleContext(GenericizedTypeContext.class,i);
		}
		public ParameterTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameterTypes(this);
		}
	}

	public final ParameterTypesContext parameterTypes() throws RecognitionException {
		ParameterTypesContext _localctx = new ParameterTypesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameterTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			genericizedType();
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(428);
				match(T__4);
				setState(429);
				genericizedType();
				}
				}
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowsTypesContext extends ParserRuleContext {
		public List<GenericizedTypeContext> genericizedType() {
			return getRuleContexts(GenericizedTypeContext.class);
		}
		public GenericizedTypeContext genericizedType(int i) {
			return getRuleContext(GenericizedTypeContext.class,i);
		}
		public ThrowsTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwsTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterThrowsTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitThrowsTypes(this);
		}
	}

	public final ThrowsTypesContext throwsTypes() throws RecognitionException {
		ThrowsTypesContext _localctx = new ThrowsTypesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_throwsTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			genericizedType();
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(436);
				match(T__4);
				setState(437);
				genericizedType();
				}
				}
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootFragmentOptionsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode FRAGMENT_SEARCH_POLICY() { return getToken(PQLParser.FRAGMENT_SEARCH_POLICY, 0); }
		public FragmentSearchPolicyContext fragmentSearchPolicy() {
			return getRuleContext(FragmentSearchPolicyContext.class,0);
		}
		public TerminalNode CHILD_SEARCH_POLICY() { return getToken(PQLParser.CHILD_SEARCH_POLICY, 0); }
		public ChildSearchPolicyContext childSearchPolicy() {
			return getRuleContext(ChildSearchPolicyContext.class,0);
		}
		public RootFragmentOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootFragmentOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterRootFragmentOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitRootFragmentOptions(this);
		}
	}

	public final RootFragmentOptionsContext rootFragmentOptions() throws RecognitionException {
		RootFragmentOptionsContext _localctx = new RootFragmentOptionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rootFragmentOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(T__2);
			setState(444);
			match(ID);
			setState(445);
			match(T__3);
			setState(446);
			bindingDecl();
			setState(447);
			match(T__4);
			setState(448);
			match(FRAGMENT_SEARCH_POLICY);
			setState(449);
			match(T__3);
			setState(450);
			fragmentSearchPolicy();
			setState(451);
			match(T__4);
			setState(452);
			match(CHILD_SEARCH_POLICY);
			setState(453);
			match(T__3);
			setState(454);
			childSearchPolicy();
			setState(455);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentOptionsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode CHILD_SEARCH_POLICY() { return getToken(PQLParser.CHILD_SEARCH_POLICY, 0); }
		public ChildSearchPolicyContext childSearchPolicy() {
			return getRuleContext(ChildSearchPolicyContext.class,0);
		}
		public TerminalNode DUPLICATE_POLICY() { return getToken(PQLParser.DUPLICATE_POLICY, 0); }
		public DuplicatePolicyContext duplicatePolicy() {
			return getRuleContext(DuplicatePolicyContext.class,0);
		}
		public FragmentOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFragmentOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFragmentOptions(this);
		}
	}

	public final FragmentOptionsContext fragmentOptions() throws RecognitionException {
		FragmentOptionsContext _localctx = new FragmentOptionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fragmentOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(T__2);
			setState(458);
			match(ID);
			setState(459);
			match(T__3);
			setState(460);
			bindingDecl();
			setState(461);
			match(T__4);
			setState(462);
			match(CHILD_SEARCH_POLICY);
			setState(463);
			match(T__3);
			setState(464);
			childSearchPolicy();
			setState(465);
			match(T__4);
			setState(466);
			match(DUPLICATE_POLICY);
			setState(467);
			match(T__3);
			setState(468);
			duplicatePolicy();
			setState(469);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChildSearchPolicyContext extends ParserRuleContext {
		public SearchPolicyContext searchPolicy() {
			return getRuleContext(SearchPolicyContext.class,0);
		}
		public ChildSearchPolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_childSearchPolicy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterChildSearchPolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitChildSearchPolicy(this);
		}
	}

	public final ChildSearchPolicyContext childSearchPolicy() throws RecognitionException {
		ChildSearchPolicyContext _localctx = new ChildSearchPolicyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_childSearchPolicy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			searchPolicy();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentSearchPolicyContext extends ParserRuleContext {
		public SearchPolicyContext searchPolicy() {
			return getRuleContext(SearchPolicyContext.class,0);
		}
		public FragmentSearchPolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentSearchPolicy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFragmentSearchPolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFragmentSearchPolicy(this);
		}
	}

	public final FragmentSearchPolicyContext fragmentSearchPolicy() throws RecognitionException {
		FragmentSearchPolicyContext _localctx = new FragmentSearchPolicyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fragmentSearchPolicy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			searchPolicy();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DuplicatePolicyContext extends ParserRuleContext {
		public TerminalNode HALT_ON_DUPLICATE() { return getToken(PQLParser.HALT_ON_DUPLICATE, 0); }
		public TerminalNode SEARCH_NEXT_UNIQUE() { return getToken(PQLParser.SEARCH_NEXT_UNIQUE, 0); }
		public TerminalNode CYCLE_CHILDREN() { return getToken(PQLParser.CYCLE_CHILDREN, 0); }
		public DuplicatePolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duplicatePolicy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterDuplicatePolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitDuplicatePolicy(this);
		}
	}

	public final DuplicatePolicyContext duplicatePolicy() throws RecognitionException {
		DuplicatePolicyContext _localctx = new DuplicatePolicyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_duplicatePolicy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (HALT_ON_DUPLICATE - 89)) | (1L << (SEARCH_NEXT_UNIQUE - 89)) | (1L << (CYCLE_CHILDREN - 89)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode REFERENCE() { return getToken(PQLParser.REFERENCE, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(REFERENCE);
			setState(478);
			match(T__3);
			setState(479);
			bindingDecl();
			setState(480);
			match(T__3);
			setState(481);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PQLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PQLParser.IDENTIFIER, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(IDENTIFIER);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(484);
				match(T__7);
				setState(485);
				match(IDENTIFIER);
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericizedTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<GenericizedTypeContext> genericizedType() {
			return getRuleContexts(GenericizedTypeContext.class);
		}
		public GenericizedTypeContext genericizedType(int i) {
			return getRuleContext(GenericizedTypeContext.class,i);
		}
		public GenericizedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericizedType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterGenericizedType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitGenericizedType(this);
		}
	}

	public final GenericizedTypeContext genericizedType() throws RecognitionException {
		GenericizedTypeContext _localctx = new GenericizedTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_genericizedType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			type();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(492);
				match(T__8);
				setState(493);
				genericizedType();
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(494);
					match(T__4);
					setState(495);
					genericizedType();
					}
					}
					setState(500);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(501);
				match(T__9);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceSearchContext extends ParserRuleContext {
		public TerminalNode REFERENCE_SEARCH() { return getToken(PQLParser.REFERENCE_SEARCH, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AnchorContext anchor() {
			return getRuleContext(AnchorContext.class,0);
		}
		public ReferenceSearchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceSearch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReferenceSearch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReferenceSearch(this);
		}
	}

	public final ReferenceSearchContext referenceSearch() throws RecognitionException {
		ReferenceSearchContext _localctx = new ReferenceSearchContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_referenceSearch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(REFERENCE_SEARCH);
			setState(506);
			match(T__3);
			setState(507);
			bindingDecl();
			setState(508);
			match(T__3);
			setState(509);
			type();
			setState(510);
			match(T__3);
			setState(511);
			anchor();
			setState(512);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnchorContext extends ParserRuleContext {
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public AnchorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anchor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAnchor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAnchor(this);
		}
	}

	public final AnchorContext anchor() throws RecognitionException {
		AnchorContext _localctx = new AnchorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_anchor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			bindingDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandsContext extends ParserRuleContext {
		public List<ReplaceContext> replace() {
			return getRuleContexts(ReplaceContext.class);
		}
		public ReplaceContext replace(int i) {
			return getRuleContext(ReplaceContext.class,i);
		}
		public List<AddMethodContext> addMethod() {
			return getRuleContexts(AddMethodContext.class);
		}
		public AddMethodContext addMethod(int i) {
			return getRuleContext(AddMethodContext.class,i);
		}
		public List<AddImportsContext> addImports() {
			return getRuleContexts(AddImportsContext.class);
		}
		public AddImportsContext addImports(int i) {
			return getRuleContext(AddImportsContext.class,i);
		}
		public List<AddFieldsContext> addFields() {
			return getRuleContexts(AddFieldsContext.class);
		}
		public AddFieldsContext addFields(int i) {
			return getRuleContext(AddFieldsContext.class,i);
		}
		public List<PrintMatchContext> printMatch() {
			return getRuleContexts(PrintMatchContext.class);
		}
		public PrintMatchContext printMatch(int i) {
			return getRuleContext(PrintMatchContext.class,i);
		}
		public List<AddParametersContext> addParameters() {
			return getRuleContexts(AddParametersContext.class);
		}
		public AddParametersContext addParameters(int i) {
			return getRuleContext(AddParametersContext.class,i);
		}
		public List<AddGetterSetterContext> addGetterSetter() {
			return getRuleContexts(AddGetterSetterContext.class);
		}
		public AddGetterSetterContext addGetterSetter(int i) {
			return getRuleContext(AddGetterSetterContext.class,i);
		}
		public List<AddMethodInvocationContext> addMethodInvocation() {
			return getRuleContexts(AddMethodInvocationContext.class);
		}
		public AddMethodInvocationContext addMethodInvocation(int i) {
			return getRuleContext(AddMethodInvocationContext.class,i);
		}
		public List<DesugarMethodInvocationContext> desugarMethodInvocation() {
			return getRuleContexts(DesugarMethodInvocationContext.class);
		}
		public DesugarMethodInvocationContext desugarMethodInvocation(int i) {
			return getRuleContext(DesugarMethodInvocationContext.class,i);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitCommands(this);
		}
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_commands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD_METHOD_INVOCATION) | (1L << ADD_GETTER_SETTER) | (1L << REPLACE) | (1L << ADD_PARAMETERS) | (1L << ADD_METHOD) | (1L << ADD_IMPORTS) | (1L << ADD_FIELDS) | (1L << DESUGAR_METHOD_INVOCATION) | (1L << PRINT_MATCH))) != 0)) {
				{
				setState(525);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case REPLACE:
					{
					setState(516);
					replace();
					}
					break;
				case ADD_METHOD:
					{
					setState(517);
					addMethod();
					}
					break;
				case ADD_IMPORTS:
					{
					setState(518);
					addImports();
					}
					break;
				case ADD_FIELDS:
					{
					setState(519);
					addFields();
					}
					break;
				case PRINT_MATCH:
					{
					setState(520);
					printMatch();
					}
					break;
				case ADD_PARAMETERS:
					{
					setState(521);
					addParameters();
					}
					break;
				case ADD_GETTER_SETTER:
					{
					setState(522);
					addGetterSetter();
					}
					break;
				case ADD_METHOD_INVOCATION:
					{
					setState(523);
					addMethodInvocation();
					}
					break;
				case DESUGAR_METHOD_INVOCATION:
					{
					setState(524);
					desugarMethodInvocation();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddMethodInvocationContext extends ParserRuleContext {
		public TerminalNode ADD_METHOD_INVOCATION() { return getToken(PQLParser.ADD_METHOD_INVOCATION, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public TerminalNode RECEIVER() { return getToken(PQLParser.RECEIVER, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public TerminalNode METHOD_NAME() { return getToken(PQLParser.METHOD_NAME, 0); }
		public MethodToInvokeContext methodToInvoke() {
			return getRuleContext(MethodToInvokeContext.class,0);
		}
		public TerminalNode ARGUMENTS() { return getToken(PQLParser.ARGUMENTS, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public AddMethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMethodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddMethodInvocation(this);
		}
	}

	public final AddMethodInvocationContext addMethodInvocation() throws RecognitionException {
		AddMethodInvocationContext _localctx = new AddMethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_addMethodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(ADD_METHOD_INVOCATION);
			setState(531);
			match(T__2);
			setState(532);
			match(ID);
			setState(533);
			match(T__3);
			setState(534);
			bindingDecl();
			setState(535);
			match(T__4);
			setState(536);
			match(TARGET_ID);
			setState(537);
			match(T__3);
			setState(538);
			targetBinding();
			setState(539);
			match(T__4);
			setState(540);
			match(RECEIVER);
			setState(541);
			match(T__3);
			setState(542);
			receiver();
			setState(543);
			match(T__4);
			setState(544);
			match(METHOD_NAME);
			setState(545);
			match(T__3);
			setState(546);
			methodToInvoke();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(547);
				match(T__4);
				setState(548);
				match(ARGUMENTS);
				setState(549);
				match(T__3);
				setState(550);
				match(T__2);
				setState(551);
				arguments();
				setState(552);
				match(T__5);
				}
			}

			setState(556);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddGetterSetterContext extends ParserRuleContext {
		public TerminalNode ADD_GETTER_SETTER() { return getToken(PQLParser.ADD_GETTER_SETTER, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public TerminalNode FIELD_TYPE() { return getToken(PQLParser.FIELD_TYPE, 0); }
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode FIELD_NAME() { return getToken(PQLParser.FIELD_NAME, 0); }
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode APPLY_TO_ANCESTOR_CLASS() { return getToken(PQLParser.APPLY_TO_ANCESTOR_CLASS, 0); }
		public ApplyToAncestorClassContext applyToAncestorClass() {
			return getRuleContext(ApplyToAncestorClassContext.class,0);
		}
		public TerminalNode IDEMPOTENT() { return getToken(PQLParser.IDEMPOTENT, 0); }
		public IdempotentContext idempotent() {
			return getRuleContext(IdempotentContext.class,0);
		}
		public TerminalNode ADD_GETTER() { return getToken(PQLParser.ADD_GETTER, 0); }
		public AddGetterContext addGetter() {
			return getRuleContext(AddGetterContext.class,0);
		}
		public TerminalNode ADD_SETTER() { return getToken(PQLParser.ADD_SETTER, 0); }
		public AddSetterContext addSetter() {
			return getRuleContext(AddSetterContext.class,0);
		}
		public TerminalNode GETTER_ACCESS_MODIFIER() { return getToken(PQLParser.GETTER_ACCESS_MODIFIER, 0); }
		public GetterAccessModifierContext getterAccessModifier() {
			return getRuleContext(GetterAccessModifierContext.class,0);
		}
		public TerminalNode SETTER_ACCESS_MODIFIER() { return getToken(PQLParser.SETTER_ACCESS_MODIFIER, 0); }
		public SetterAccessModifierContext setterAccessModifier() {
			return getRuleContext(SetterAccessModifierContext.class,0);
		}
		public AddGetterSetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addGetterSetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddGetterSetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddGetterSetter(this);
		}
	}

	public final AddGetterSetterContext addGetterSetter() throws RecognitionException {
		AddGetterSetterContext _localctx = new AddGetterSetterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_addGetterSetter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			match(ADD_GETTER_SETTER);
			setState(559);
			match(T__2);
			setState(560);
			match(ID);
			setState(561);
			match(T__3);
			setState(562);
			bindingDecl();
			setState(563);
			match(T__4);
			setState(564);
			match(TARGET_ID);
			setState(565);
			match(T__3);
			setState(566);
			targetBinding();
			setState(567);
			match(T__4);
			setState(568);
			match(FIELD_TYPE);
			setState(569);
			match(T__3);
			setState(570);
			fieldType();
			setState(571);
			match(T__4);
			setState(572);
			match(FIELD_NAME);
			setState(573);
			match(T__3);
			setState(574);
			fieldName();
			setState(575);
			match(T__4);
			setState(576);
			match(APPLY_TO_ANCESTOR_CLASS);
			setState(577);
			match(T__3);
			setState(578);
			applyToAncestorClass();
			setState(579);
			match(T__4);
			setState(580);
			match(IDEMPOTENT);
			setState(581);
			match(T__3);
			setState(582);
			idempotent();
			setState(583);
			match(T__4);
			setState(584);
			match(ADD_GETTER);
			setState(585);
			match(T__3);
			setState(586);
			addGetter();
			setState(587);
			match(T__4);
			setState(588);
			match(ADD_SETTER);
			setState(589);
			match(T__3);
			setState(590);
			addSetter();
			setState(591);
			match(T__4);
			setState(592);
			match(GETTER_ACCESS_MODIFIER);
			setState(593);
			match(T__3);
			setState(594);
			getterAccessModifier();
			setState(595);
			match(T__4);
			setState(596);
			match(SETTER_ACCESS_MODIFIER);
			setState(597);
			match(T__3);
			setState(598);
			setterAccessModifier();
			setState(599);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddParametersContext extends ParserRuleContext {
		public TerminalNode ADD_PARAMETERS() { return getToken(PQLParser.ADD_PARAMETERS, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public AddParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddParameters(this);
		}
	}

	public final AddParametersContext addParameters() throws RecognitionException {
		AddParametersContext _localctx = new AddParametersContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_addParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(ADD_PARAMETERS);
			setState(602);
			match(T__2);
			setState(603);
			match(ID);
			setState(604);
			match(T__3);
			setState(605);
			bindingDecl();
			setState(606);
			match(T__4);
			setState(607);
			match(TARGET_ID);
			setState(608);
			match(T__3);
			setState(609);
			targetBinding();
			setState(610);
			match(T__5);
			setState(611);
			match(T__0);
			setState(612);
			parameters();
			setState(613);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReplaceContext extends ParserRuleContext {
		public TerminalNode REPLACE() { return getToken(PQLParser.REPLACE, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public ReplaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_replace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReplace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReplace(this);
		}
	}

	public final ReplaceContext replace() throws RecognitionException {
		ReplaceContext _localctx = new ReplaceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_replace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			match(REPLACE);
			setState(616);
			match(T__2);
			setState(617);
			match(ID);
			setState(618);
			match(T__3);
			setState(619);
			bindingDecl();
			setState(620);
			match(T__4);
			setState(621);
			match(TARGET_ID);
			setState(622);
			match(T__3);
			setState(623);
			targetBinding();
			setState(624);
			match(T__5);
			setState(625);
			match(T__0);
			setState(626);
			codeBlock();
			setState(627);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeBlockContext extends ParserRuleContext {
		public TerminalNode CODE_BLOCK() { return getToken(PQLParser.CODE_BLOCK, 0); }
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitCodeBlock(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_codeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(CODE_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddMethodContext extends ParserRuleContext {
		public TerminalNode ADD_METHOD() { return getToken(PQLParser.ADD_METHOD, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public ApplyToAncestorClassContext applyToAncestorClass() {
			return getRuleContext(ApplyToAncestorClassContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public AddMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddMethod(this);
		}
	}

	public final AddMethodContext addMethod() throws RecognitionException {
		AddMethodContext _localctx = new AddMethodContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_addMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(ADD_METHOD);
			setState(632);
			match(T__2);
			setState(633);
			match(ID);
			setState(634);
			match(T__3);
			setState(635);
			bindingDecl();
			setState(636);
			match(T__4);
			setState(637);
			match(TARGET_ID);
			setState(638);
			match(T__3);
			setState(639);
			targetBinding();
			setState(640);
			match(T__4);
			setState(641);
			applyToAncestorClass();
			setState(642);
			match(T__5);
			setState(643);
			match(T__0);
			setState(644);
			codeBlock();
			setState(645);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddImportsContext extends ParserRuleContext {
		public TerminalNode ADD_IMPORTS() { return getToken(PQLParser.ADD_IMPORTS, 0); }
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public AddImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addImports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddImports(this);
		}
	}

	public final AddImportsContext addImports() throws RecognitionException {
		AddImportsContext _localctx = new AddImportsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_addImports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			match(ADD_IMPORTS);
			setState(648);
			match(T__10);
			setState(649);
			match(T__0);
			setState(650);
			imports();
			setState(651);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddFieldsContext extends ParserRuleContext {
		public TerminalNode ADD_FIELDS() { return getToken(PQLParser.ADD_FIELDS, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public TerminalNode APPLY_TO_ANCESTOR_CLASS() { return getToken(PQLParser.APPLY_TO_ANCESTOR_CLASS, 0); }
		public ApplyToAncestorClassContext applyToAncestorClass() {
			return getRuleContext(ApplyToAncestorClassContext.class,0);
		}
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public AddFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addFields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddFields(this);
		}
	}

	public final AddFieldsContext addFields() throws RecognitionException {
		AddFieldsContext _localctx = new AddFieldsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_addFields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(ADD_FIELDS);
			setState(654);
			match(T__2);
			setState(655);
			match(ID);
			setState(656);
			match(T__3);
			setState(657);
			bindingDecl();
			setState(658);
			match(T__4);
			setState(659);
			match(TARGET_ID);
			setState(660);
			match(T__3);
			setState(661);
			targetBinding();
			setState(662);
			match(T__4);
			setState(663);
			match(APPLY_TO_ANCESTOR_CLASS);
			setState(664);
			match(T__3);
			setState(665);
			applyToAncestorClass();
			setState(666);
			match(T__5);
			setState(667);
			match(T__0);
			setState(668);
			fields();
			setState(669);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesugarMethodInvocationContext extends ParserRuleContext {
		public TerminalNode DESUGAR_METHOD_INVOCATION() { return getToken(PQLParser.DESUGAR_METHOD_INVOCATION, 0); }
		public TerminalNode ID() { return getToken(PQLParser.ID, 0); }
		public BindingDeclContext bindingDecl() {
			return getRuleContext(BindingDeclContext.class,0);
		}
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public DesugarMethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desugarMethodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterDesugarMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitDesugarMethodInvocation(this);
		}
	}

	public final DesugarMethodInvocationContext desugarMethodInvocation() throws RecognitionException {
		DesugarMethodInvocationContext _localctx = new DesugarMethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_desugarMethodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			match(DESUGAR_METHOD_INVOCATION);
			setState(672);
			match(T__2);
			setState(673);
			match(ID);
			setState(674);
			match(T__3);
			setState(675);
			bindingDecl();
			setState(676);
			match(T__4);
			setState(677);
			match(TARGET_ID);
			setState(678);
			match(T__3);
			setState(679);
			targetBinding();
			setState(680);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintMatchContext extends ParserRuleContext {
		public TerminalNode PRINT_MATCH() { return getToken(PQLParser.PRINT_MATCH, 0); }
		public TerminalNode TARGET_ID() { return getToken(PQLParser.TARGET_ID, 0); }
		public TargetBindingContext targetBinding() {
			return getRuleContext(TargetBindingContext.class,0);
		}
		public PrintMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterPrintMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitPrintMatch(this);
		}
	}

	public final PrintMatchContext printMatch() throws RecognitionException {
		PrintMatchContext _localctx = new PrintMatchContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_printMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(PRINT_MATCH);
			setState(683);
			match(T__2);
			setState(684);
			match(TARGET_ID);
			setState(685);
			match(T__3);
			setState(686);
			targetBinding();
			setState(687);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFields(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			field();
			setState(694);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(690);
				match(T__4);
				setState(691);
				field();
				}
				}
				setState(696);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode IDEMPOTENT() { return getToken(PQLParser.IDEMPOTENT, 0); }
		public IdempotentContext idempotent() {
			return getRuleContext(IdempotentContext.class,0);
		}
		public TerminalNode ACCESS_MODIFIER() { return getToken(PQLParser.ACCESS_MODIFIER, 0); }
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public TerminalNode STATIC_MODIFIER() { return getToken(PQLParser.STATIC_MODIFIER, 0); }
		public StaticModifierContext staticModifier() {
			return getRuleContext(StaticModifierContext.class,0);
		}
		public TerminalNode FINAL_MODIFIER() { return getToken(PQLParser.FINAL_MODIFIER, 0); }
		public FinalModifierContext finalModifier() {
			return getRuleContext(FinalModifierContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(PQLParser.TYPE, 0); }
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(PQLParser.NAME, 0); }
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode INITIALIZER() { return getToken(PQLParser.INITIALIZER, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(T__2);
			setState(698);
			match(IDEMPOTENT);
			setState(699);
			match(T__3);
			setState(700);
			idempotent();
			setState(701);
			match(T__4);
			setState(702);
			match(ACCESS_MODIFIER);
			setState(703);
			match(T__3);
			setState(704);
			accessModifier();
			setState(705);
			match(T__4);
			setState(706);
			match(STATIC_MODIFIER);
			setState(707);
			match(T__3);
			setState(708);
			staticModifier();
			setState(709);
			match(T__4);
			setState(710);
			match(FINAL_MODIFIER);
			setState(711);
			match(T__3);
			setState(712);
			finalModifier();
			setState(713);
			match(T__4);
			setState(714);
			match(TYPE);
			setState(715);
			match(T__3);
			setState(716);
			fieldType();
			setState(717);
			match(T__4);
			setState(718);
			match(NAME);
			setState(719);
			match(T__3);
			setState(720);
			fieldName();
			setState(721);
			match(T__4);
			setState(722);
			match(INITIALIZER);
			setState(723);
			match(T__3);
			setState(724);
			initializer();
			setState(725);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public List<ImportTypeContext> importType() {
			return getRuleContexts(ImportTypeContext.class);
		}
		public ImportTypeContext importType(int i) {
			return getRuleContext(ImportTypeContext.class,i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitImports(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			importType();
			setState(732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(728);
				match(T__4);
				setState(729);
				importType();
				}
				}
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			argument();
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(736);
				match(T__4);
				setState(737);
				argument();
				}
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			parameter();
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(746);
				match(T__4);
				setState(747);
				parameter();
				}
				}
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ADD_AFTER_POSITION() { return getToken(PQLParser.ADD_AFTER_POSITION, 0); }
		public ParameterPositionContext parameterPosition() {
			return getRuleContext(ParameterPositionContext.class,0);
		}
		public TerminalNode FINAL_MODIFIER() { return getToken(PQLParser.FINAL_MODIFIER, 0); }
		public FinalModifierContext finalModifier() {
			return getRuleContext(FinalModifierContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(PQLParser.TYPE, 0); }
		public ParameterTypeContext parameterType() {
			return getRuleContext(ParameterTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(PQLParser.NAME, 0); }
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(T__2);
			setState(754);
			match(ADD_AFTER_POSITION);
			setState(755);
			match(T__3);
			setState(756);
			parameterPosition();
			setState(757);
			match(T__4);
			setState(758);
			match(FINAL_MODIFIER);
			setState(759);
			match(T__3);
			setState(760);
			finalModifier();
			setState(761);
			match(T__4);
			setState(762);
			match(TYPE);
			setState(763);
			match(T__3);
			setState(764);
			parameterType();
			setState(765);
			match(T__4);
			setState(766);
			match(NAME);
			setState(767);
			match(T__3);
			setState(768);
			parameterName();
			setState(769);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterPositionContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(PQLParser.INT_LITERAL, 0); }
		public ParameterPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameterPosition(this);
		}
	}

	public final ParameterPositionContext parameterPosition() throws RecognitionException {
		ParameterPositionContext _localctx = new ParameterPositionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_parameterPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			match(INT_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterTypeContext extends ParserRuleContext {
		public GenericizedTypeContext genericizedType() {
			return getRuleContext(GenericizedTypeContext.class,0);
		}
		public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameterType(this);
		}
	}

	public final ParameterTypeContext parameterType() throws RecognitionException {
		ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parameterType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			genericizedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterNameContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public ParameterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParameterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParameterName(this);
		}
	}

	public final ParameterNameContext parameterName() throws RecognitionException {
		ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parameterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldTypeContext extends ParserRuleContext {
		public GenericizedTypeContext genericizedType() {
			return getRuleContext(GenericizedTypeContext.class,0);
		}
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFieldType(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			genericizedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportTypeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PQLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PQLParser.IDENTIFIER, i);
		}
		public ImportTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterImportType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitImportType(this);
		}
	}

	public final ImportTypeContext importType() throws RecognitionException {
		ImportTypeContext _localctx = new ImportTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_importType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			match(T__0);
			setState(786);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(782);
					match(IDENTIFIER);
					setState(783);
					match(T__7);
					}
					} 
				}
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(789);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(790);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdempotentContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public IdempotentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idempotent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterIdempotent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitIdempotent(this);
		}
	}

	public final IdempotentContext idempotent() throws RecognitionException {
		IdempotentContext _localctx = new IdempotentContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_idempotent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessModifierContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAccessModifier(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_accessModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetterAccessModifierContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public GetterAccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getterAccessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterGetterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitGetterAccessModifier(this);
		}
	}

	public final GetterAccessModifierContext getterAccessModifier() throws RecognitionException {
		GetterAccessModifierContext _localctx = new GetterAccessModifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_getterAccessModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetterAccessModifierContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public SetterAccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setterAccessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterSetterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitSetterAccessModifier(this);
		}
	}

	public final SetterAccessModifierContext setterAccessModifier() throws RecognitionException {
		SetterAccessModifierContext _localctx = new SetterAccessModifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_setterAccessModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitScope(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitReceiver(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_receiver);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodToInvokeContext extends ParserRuleContext {
		public PqlExpressionContext pqlExpression() {
			return getRuleContext(PqlExpressionContext.class,0);
		}
		public MethodToInvokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodToInvoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterMethodToInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitMethodToInvoke(this);
		}
	}

	public final MethodToInvokeContext methodToInvoke() throws RecognitionException {
		MethodToInvokeContext _localctx = new MethodToInvokeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_methodToInvoke);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			pqlExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PqlExpressionContext extends ParserRuleContext {
		public ContextReferencesContext contextReferences() {
			return getRuleContext(ContextReferencesContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NameExpressionContext nameExpression() {
			return getRuleContext(NameExpressionContext.class,0);
		}
		public PqlExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pqlExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterPqlExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitPqlExpression(this);
		}
	}

	public final PqlExpressionContext pqlExpression() throws RecognitionException {
		PqlExpressionContext _localctx = new PqlExpressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_pqlExpression);
		try {
			setState(811);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(808);
				contextReferences();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(809);
				stringLiteral();
				}
				break;
			case T__22:
			case T__23:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(810);
				nameExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextReferencesContext extends ParserRuleContext {
		public StringContextReferenceContext stringContextReference() {
			return getRuleContext(StringContextReferenceContext.class,0);
		}
		public StringArrayContextReferenceContext stringArrayContextReference() {
			return getRuleContext(StringArrayContextReferenceContext.class,0);
		}
		public ContextReferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextReferences; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterContextReferences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitContextReferences(this);
		}
	}

	public final ContextReferencesContext contextReferences() throws RecognitionException {
		ContextReferencesContext _localctx = new ContextReferencesContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_contextReferences);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(813);
				stringContextReference();
				}
				break;
			case 2:
				{
				setState(814);
				stringArrayContextReference();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContextReferenceContext extends ParserRuleContext {
		public BindingLookupContext bindingLookup() {
			return getRuleContext(BindingLookupContext.class,0);
		}
		public StringContextReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringContextReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterStringContextReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitStringContextReference(this);
		}
	}

	public final StringContextReferenceContext stringContextReference() throws RecognitionException {
		StringContextReferenceContext _localctx = new StringContextReferenceContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_stringContextReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			match(T__16);
			setState(818);
			match(T__17);
			setState(819);
			match(T__7);
			setState(820);
			match(T__18);
			setState(821);
			match(T__2);
			setState(822);
			bindingLookup();
			setState(823);
			match(T__5);
			setState(824);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringArrayContextReferenceContext extends ParserRuleContext {
		public BindingLookupContext bindingLookup() {
			return getRuleContext(BindingLookupContext.class,0);
		}
		public LookupIndexContext lookupIndex() {
			return getRuleContext(LookupIndexContext.class,0);
		}
		public StringArrayContextReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringArrayContextReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterStringArrayContextReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitStringArrayContextReference(this);
		}
	}

	public final StringArrayContextReferenceContext stringArrayContextReference() throws RecognitionException {
		StringArrayContextReferenceContext _localctx = new StringArrayContextReferenceContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_stringArrayContextReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			match(T__16);
			setState(827);
			match(T__17);
			setState(828);
			match(T__7);
			setState(829);
			match(T__19);
			setState(830);
			match(T__2);
			setState(831);
			bindingLookup();
			setState(832);
			match(T__5);
			setState(833);
			match(T__20);
			setState(834);
			lookupIndex();
			setState(835);
			match(T__21);
			setState(836);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public NameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterNameExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitNameExpression(this);
		}
	}

	public final NameExpressionContext nameExpression() throws RecognitionException {
		NameExpressionContext _localctx = new NameExpressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_nameExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__23 || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingLookupContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public BindingLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingLookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterBindingLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitBindingLookup(this);
		}
	}

	public final BindingLookupContext bindingLookup() throws RecognitionException {
		BindingLookupContext _localctx = new BindingLookupContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_bindingLookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LookupIndexContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(PQLParser.INT_LITERAL, 0); }
		public LookupIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterLookupIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitLookupIndex(this);
		}
	}

	public final LookupIndexContext lookupIndex() throws RecognitionException {
		LookupIndexContext _localctx = new LookupIndexContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_lookupIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			match(INT_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Addition_subtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Addition_subtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddition_subtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddition_subtraction(this);
		}
	}
	public static class Array_referenceContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Array_referenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterArray_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitArray_reference(this);
		}
	}
	public static class NegationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitNegation(this);
		}
	}
	public static class Parenthesized_exprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Parenthesized_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterParenthesized_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitParenthesized_expr(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitString(this);
		}
	}
	public static class NullContext extends ExpressionContext {
		public NullContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitNull(this);
		}
	}
	public static class Function_callContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Function_callContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFunction_call(this);
		}
	}
	public static class Unary_minusContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Unary_minusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterUnary_minus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitUnary_minus(this);
		}
	}
	public static class ThisContext extends ExpressionContext {
		public ThisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitThis(this);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitMultiplication(this);
		}
	}
	public static class DecimalContext extends ExpressionContext {
		public DecimalLiteralContext decimalLiteral() {
			return getRuleContext(DecimalLiteralContext.class,0);
		}
		public DecimalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitDecimal(this);
		}
	}
	public static class EqualityContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitEquality(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 130;
		enterRecursionRule(_localctx, 130, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(868);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				_localctx = new Function_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(845);
				match(IDENTIFIER);
				setState(846);
				match(T__2);
				setState(848);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (IDENTIFIER - 98)) | (1L << (DECIMAL_LITERAL - 98)) | (1L << (STRING_LITERAL - 98)))) != 0)) {
					{
					setState(847);
					expressions();
					}
				}

				setState(850);
				match(T__5);
				}
				break;
			case 2:
				{
				_localctx = new Array_referenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(851);
				match(IDENTIFIER);
				setState(852);
				match(T__20);
				setState(853);
				expression(0);
				setState(854);
				match(T__21);
				}
				break;
			case 3:
				{
				_localctx = new Unary_minusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(856);
				match(T__24);
				setState(857);
				expression(10);
				}
				break;
			case 4:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(858);
				match(T__25);
				setState(859);
				expression(9);
				}
				break;
			case 5:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(860);
				decimalLiteral();
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(861);
				stringLiteral();
				}
				break;
			case 7:
				{
				_localctx = new Parenthesized_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(862);
				match(T__2);
				setState(863);
				expression(0);
				setState(864);
				match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(866);
				match(T__23);
				}
				break;
			case 9:
				{
				_localctx = new NullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(867);
				match(T__22);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(881);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(879);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(870);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(871);
						match(T__11);
						setState(872);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new Addition_subtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(873);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(874);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__26) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(875);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new EqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(876);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(877);
						match(T__27);
						setState(878);
						expression(7);
						}
						break;
					}
					} 
				}
				setState(883);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			expression(0);
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(885);
				match(T__4);
				setState(886);
				expression(0);
				}
				}
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddGetterContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public AddGetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addGetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddGetter(this);
		}
	}

	public final AddGetterContext addGetter() throws RecognitionException {
		AddGetterContext _localctx = new AddGetterContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_addGetter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddSetterContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public AddSetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAddSetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAddSetter(this);
		}
	}

	public final AddSetterContext addSetter() throws RecognitionException {
		AddSetterContext _localctx = new AddSetterContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_addSetter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(PQLParser.STRING_LITERAL, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalLiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(PQLParser.DECIMAL_LITERAL, 0); }
		public DecimalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitDecimalLiteral(this);
		}
	}

	public final DecimalLiteralContext decimalLiteral() throws RecognitionException {
		DecimalLiteralContext _localctx = new DecimalLiteralContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_decimalLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			match(DECIMAL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_booleanLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApplyToAncestorClassContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public ApplyToAncestorClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applyToAncestorClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterApplyToAncestorClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitApplyToAncestorClass(this);
		}
	}

	public final ApplyToAncestorClassContext applyToAncestorClass() throws RecognitionException {
		ApplyToAncestorClassContext _localctx = new ApplyToAncestorClassContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_applyToAncestorClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticModifierContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public StaticModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterStaticModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitStaticModifier(this);
		}
	}

	public final StaticModifierContext staticModifier() throws RecognitionException {
		StaticModifierContext _localctx = new StaticModifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_staticModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalModifierContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public FinalModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterFinalModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitFinalModifier(this);
		}
	}

	public final FinalModifierContext finalModifier() throws RecognitionException {
		FinalModifierContext _localctx = new FinalModifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_finalModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractModifierContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public AbstractModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterAbstractModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitAbstractModifier(this);
		}
	}

	public final AbstractModifierContext abstractModifier() throws RecognitionException {
		AbstractModifierContext _localctx = new AbstractModifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_abstractModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedClassContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public NestedClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterNestedClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitNestedClass(this);
		}
	}

	public final NestedClassContext nestedClass() throws RecognitionException {
		NestedClassContext _localctx = new NestedClassContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_nestedClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NativeModifierContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public NativeModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterNativeModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitNativeModifier(this);
		}
	}

	public final NativeModifierContext nativeModifier() throws RecognitionException {
		NativeModifierContext _localctx = new NativeModifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_nativeModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynchronizedModifierContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PQLParser.BOOL_LITERAL, 0); }
		public SynchronizedModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterSynchronizedModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitSynchronizedModifier(this);
		}
	}

	public final SynchronizedModifierContext synchronizedModifier() throws RecognitionException {
		SynchronizedModifierContext _localctx = new SynchronizedModifierContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_synchronizedModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderContext extends ParserRuleContext {
		public TerminalNode ORDERED() { return getToken(PQLParser.ORDERED, 0); }
		public TerminalNode UNORDERED() { return getToken(PQLParser.UNORDERED, 0); }
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitOrder(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			_la = _input.LA(1);
			if ( !(_la==ORDERED || _la==UNORDERED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingRefContext extends ParserRuleContext {
		public TerminalNode BINDING_REF() { return getToken(PQLParser.BINDING_REF, 0); }
		public BindingRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterBindingRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitBindingRef(this);
		}
	}

	public final BindingRefContext bindingRef() throws RecognitionException {
		BindingRefContext _localctx = new BindingRefContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_bindingRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			match(BINDING_REF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public BindingDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindingDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterBindingDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitBindingDecl(this);
		}
	}

	public final BindingDeclContext bindingDecl() throws RecognitionException {
		BindingDeclContext _localctx = new BindingDeclContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_bindingDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetBindingContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQLParser.IDENTIFIER, 0); }
		public TargetBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterTargetBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitTargetBinding(this);
		}
	}

	public final TargetBindingContext targetBinding() throws RecognitionException {
		TargetBindingContext _localctx = new TargetBindingContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_targetBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchPolicyContext extends ParserRuleContext {
		public TerminalNode RESTART_AT_HOME() { return getToken(PQLParser.RESTART_AT_HOME, 0); }
		public TerminalNode RESTART_AT_END_LAST_MATCH() { return getToken(PQLParser.RESTART_AT_END_LAST_MATCH, 0); }
		public SearchPolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchPolicy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterSearchPolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitSearchPolicy(this);
		}
	}

	public final SearchPolicyContext searchPolicy() throws RecognitionException {
		SearchPolicyContext _localctx = new SearchPolicyContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_searchPolicy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
			_la = _input.LA(1);
			if ( !(_la==RESTART_AT_HOME || _la==RESTART_AT_END_LAST_MATCH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContextContext extends ParserRuleContext {
		public TerminalNode EXPRESSION() { return getToken(PQLParser.EXPRESSION, 0); }
		public TerminalNode STATEMENT() { return getToken(PQLParser.STATEMENT, 0); }
		public PatternContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternContext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).enterPatternContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQLListener ) ((PQLListener)listener).exitPatternContext(this);
		}
	}

	public final PatternContextContext patternContext() throws RecognitionException {
		PatternContextContext _localctx = new PatternContextContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_patternContext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			_la = _input.LA(1);
			if ( !(_la==EXPRESSION || _la==STATEMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 65:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3g\u03a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\6\4\u00be\n\4\r\4\16\4\u00bf\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\5\6\u00cc\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d7"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u00dd\n\7\3\7\3\7\3\7\3\7\5\7\u00e3\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u00ec\n\7\3\7\3\7\3\7\3\7\5\7\u00f2\n\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0100\n\b\3\b\3\b\3\b"+
		"\3\b\5\b\u0106\n\b\3\b\3\b\3\b\3\b\5\b\u010c\n\b\3\b\3\b\3\b\3\b\5\b\u0112"+
		"\n\b\3\b\3\b\3\b\3\b\5\b\u0118\n\b\3\b\3\b\3\b\3\b\5\b\u011e\n\b\3\b\3"+
		"\b\3\b\3\b\5\b\u0124\n\b\3\b\3\b\3\b\3\b\5\b\u012a\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u0133\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u013c\n\b\3"+
		"\b\3\b\3\b\3\b\5\b\u0142\n\b\3\b\3\b\3\b\3\b\5\b\u0148\n\b\3\b\3\b\3\b"+
		"\5\b\u014d\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u015a\n"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0160\n\t\3\t\3\t\3\t\3\t\5\t\u0166\n\t\3\t\3\t"+
		"\3\t\3\t\5\t\u016c\n\t\3\t\3\t\3\t\3\t\5\t\u0172\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u017b\n\t\3\t\3\t\3\t\3\t\5\t\u0181\n\t\3\t\3\t\3\t\3\t"+
		"\5\t\u0187\n\t\3\t\3\t\3\t\3\t\5\t\u018d\n\t\3\t\3\t\3\t\5\t\u0192\n\t"+
		"\3\t\3\t\3\n\3\n\3\n\7\n\u0199\n\n\f\n\16\n\u019c\13\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\7\17\u01a9\n\17\f\17\16\17\u01ac\13"+
		"\17\3\20\3\20\3\20\7\20\u01b1\n\20\f\20\16\20\u01b4\13\20\3\21\3\21\3"+
		"\21\7\21\u01b9\n\21\f\21\16\21\u01bc\13\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30\u01e9\n\30\f\30"+
		"\16\30\u01ec\13\30\3\31\3\31\3\31\3\31\3\31\7\31\u01f3\n\31\f\31\16\31"+
		"\u01f6\13\31\3\31\3\31\5\31\u01fa\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7"+
		"\34\u0210\n\34\f\34\16\34\u0213\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u022d\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\7\'\u02b7\n\'\f\'\16\'\u02ba\13\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\7)\u02dd\n)\f)\16)\u02e0\13)\3*\3*\3*\7*\u02e5\n*\f*"+
		"\16*\u02e8\13*\3+\3+\3,\3,\3,\7,\u02ef\n,\f,\16,\u02f2\13,\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\63\7\63\u0313\n\63\f\63\16\63\u0316\13\63"+
		"\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3<\5<\u032e\n<\3=\3=\5=\u0332\n=\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3"+
		"C\3C\5C\u0353\nC\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3"+
		"C\5C\u0367\nC\3C\3C\3C\3C\3C\3C\3C\3C\3C\7C\u0372\nC\fC\16C\u0375\13C"+
		"\3D\3D\3D\7D\u037a\nD\fD\16D\u037d\13D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3"+
		"J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3"+
		"U\3V\3V\3V\2\3\u0084W\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\2\n\3\2[]\4\2\16\16dd\3\2\17\22\4"+
		"\2\31\32dd\4\2\33\33\35\35\3\2\61\62\3\2QR\3\2ST\2\u0394\2\u00ac\3\2\2"+
		"\2\4\u00b5\3\2\2\2\6\u00bd\3\2\2\2\b\u00c1\3\2\2\2\n\u00cb\3\2\2\2\f\u00cd"+
		"\3\2\2\2\16\u00f6\3\2\2\2\20\u0150\3\2\2\2\22\u0195\3\2\2\2\24\u019d\3"+
		"\2\2\2\26\u019f\3\2\2\2\30\u01a1\3\2\2\2\32\u01a3\3\2\2\2\34\u01a5\3\2"+
		"\2\2\36\u01ad\3\2\2\2 \u01b5\3\2\2\2\"\u01bd\3\2\2\2$\u01cb\3\2\2\2&\u01d9"+
		"\3\2\2\2(\u01db\3\2\2\2*\u01dd\3\2\2\2,\u01df\3\2\2\2.\u01e5\3\2\2\2\60"+
		"\u01ed\3\2\2\2\62\u01fb\3\2\2\2\64\u0204\3\2\2\2\66\u0211\3\2\2\28\u0214"+
		"\3\2\2\2:\u0230\3\2\2\2<\u025b\3\2\2\2>\u0269\3\2\2\2@\u0277\3\2\2\2B"+
		"\u0279\3\2\2\2D\u0289\3\2\2\2F\u028f\3\2\2\2H\u02a1\3\2\2\2J\u02ac\3\2"+
		"\2\2L\u02b3\3\2\2\2N\u02bb\3\2\2\2P\u02d9\3\2\2\2R\u02e1\3\2\2\2T\u02e9"+
		"\3\2\2\2V\u02eb\3\2\2\2X\u02f3\3\2\2\2Z\u0305\3\2\2\2\\\u0307\3\2\2\2"+
		"^\u0309\3\2\2\2`\u030b\3\2\2\2b\u030d\3\2\2\2d\u030f\3\2\2\2f\u031a\3"+
		"\2\2\2h\u031c\3\2\2\2j\u031e\3\2\2\2l\u0320\3\2\2\2n\u0322\3\2\2\2p\u0324"+
		"\3\2\2\2r\u0326\3\2\2\2t\u0328\3\2\2\2v\u032d\3\2\2\2x\u0331\3\2\2\2z"+
		"\u0333\3\2\2\2|\u033c\3\2\2\2~\u0348\3\2\2\2\u0080\u034a\3\2\2\2\u0082"+
		"\u034c\3\2\2\2\u0084\u0366\3\2\2\2\u0086\u0376\3\2\2\2\u0088\u037e\3\2"+
		"\2\2\u008a\u0380\3\2\2\2\u008c\u0382\3\2\2\2\u008e\u0384\3\2\2\2\u0090"+
		"\u0386\3\2\2\2\u0092\u0388\3\2\2\2\u0094\u038a\3\2\2\2\u0096\u038c\3\2"+
		"\2\2\u0098\u038e\3\2\2\2\u009a\u0390\3\2\2\2\u009c\u0392\3\2\2\2\u009e"+
		"\u0394\3\2\2\2\u00a0\u0396\3\2\2\2\u00a2\u0398\3\2\2\2\u00a4\u039a\3\2"+
		"\2\2\u00a6\u039c\3\2\2\2\u00a8\u039e\3\2\2\2\u00aa\u03a0\3\2\2\2\u00ac"+
		"\u00ad\7,\2\2\u00ad\u00ae\7\3\2\2\u00ae\u00af\5\4\3\2\u00af\u00b0\7\4"+
		"\2\2\u00b0\u00b1\7.\2\2\u00b1\u00b2\7\3\2\2\u00b2\u00b3\5\66\34\2\u00b3"+
		"\u00b4\7\4\2\2\u00b4\3\3\2\2\2\u00b5\u00b6\7-\2\2\u00b6\u00b7\5\"\22\2"+
		"\u00b7\u00b8\7\3\2\2\u00b8\u00b9\5\6\4\2\u00b9\u00ba\7\4\2\2\u00ba\5\3"+
		"\2\2\2\u00bb\u00be\5\b\5\2\u00bc\u00be\5\n\6\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\7\3\2\2\2\u00c1\u00c2\7-\2\2\u00c2\u00c3\5$\23\2\u00c3\u00c4"+
		"\7\3\2\2\u00c4\u00c5\5\6\4\2\u00c5\u00c6\7\4\2\2\u00c6\t\3\2\2\2\u00c7"+
		"\u00cc\5\62\32\2\u00c8\u00cc\5\f\7\2\u00c9\u00cc\5\20\t\2\u00ca\u00cc"+
		"\5\16\b\2\u00cb\u00c7\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cb\u00c9\3\2\2\2"+
		"\u00cb\u00ca\3\2\2\2\u00cc\13\3\2\2\2\u00cd\u00ce\7<\2\2\u00ce\u00cf\7"+
		"\5\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1\7\6\2\2\u00d1\u00d6\5\u00a4S\2\u00d2"+
		"\u00d3\7\7\2\2\u00d3\u00d4\7@\2\2\u00d4\u00d5\7\6\2\2\u00d5\u00d7\5\26"+
		"\f\2\u00d6\u00d2\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00dc\3\2\2\2\u00d8"+
		"\u00d9\7\7\2\2\u00d9\u00da\7C\2\2\u00da\u00db\7\6\2\2\u00db\u00dd\5\32"+
		"\16\2\u00dc\u00d8\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e2\3\2\2\2\u00de"+
		"\u00df\7\7\2\2\u00df\u00e0\7G\2\2\u00e0\u00e1\7\6\2\2\u00e1\u00e3\5\u00aa"+
		"V\2\u00e2\u00de\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00eb\3\2\2\2\u00e4"+
		"\u00e5\7\7\2\2\u00e5\u00e6\7H\2\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\7\5"+
		"\2\2\u00e8\u00e9\5\34\17\2\u00e9\u00ea\7\b\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e4\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\7\7"+
		"\2\2\u00ee\u00ef\7N\2\2\u00ef\u00f0\7\6\2\2\u00f0\u00f2\5*\26\2\u00f1"+
		"\u00ed\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\b"+
		"\2\2\u00f4\u00f5\7\t\2\2\u00f5\r\3\2\2\2\u00f6\u00f7\7=\2\2\u00f7\u00f8"+
		"\7\5\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7\6\2\2\u00fa\u00ff\5\u00a4S\2"+
		"\u00fb\u00fc\7\7\2\2\u00fc\u00fd\7?\2\2\u00fd\u00fe\7\6\2\2\u00fe\u0100"+
		"\5h\65\2\u00ff\u00fb\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0105\3\2\2\2\u0101"+
		"\u0102\7\7\2\2\u0102\u0103\7U\2\2\u0103\u0104\7\6\2\2\u0104\u0106\5\u0094"+
		"K\2\u0105\u0101\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010b\3\2\2\2\u0107"+
		"\u0108\7\7\2\2\u0108\u0109\7W\2\2\u0109\u010a\7\6\2\2\u010a\u010c\5\u0098"+
		"M\2\u010b\u0107\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0111\3\2\2\2\u010d"+
		"\u010e\7\7\2\2\u010e\u010f\7V\2\2\u010f\u0110\7\6\2\2\u0110\u0112\5\u0096"+
		"L\2\u0111\u010d\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0117\3\2\2\2\u0113"+
		"\u0114\7\7\2\2\u0114\u0115\7Y\2\2\u0115\u0116\7\6\2\2\u0116\u0118\5\u009c"+
		"O\2\u0117\u0113\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011d\3\2\2\2\u0119"+
		"\u011a\7\7\2\2\u011a\u011b\7Z\2\2\u011b\u011c\7\6\2\2\u011c\u011e\5\u009e"+
		"P\2\u011d\u0119\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0123\3\2\2\2\u011f"+
		"\u0120\7\7\2\2\u0120\u0121\7A\2\2\u0121\u0122\7\6\2\2\u0122\u0124\5\30"+
		"\r\2\u0123\u011f\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0129\3\2\2\2\u0125"+
		"\u0126\7\7\2\2\u0126\u0127\7C\2\2\u0127\u0128\7\6\2\2\u0128\u012a\5\32"+
		"\16\2\u0129\u0125\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0132\3\2\2\2\u012b"+
		"\u012c\7\7\2\2\u012c\u012d\7I\2\2\u012d\u012e\7\6\2\2\u012e\u012f\7\5"+
		"\2\2\u012f\u0130\5\36\20\2\u0130\u0131\7\b\2\2\u0131\u0133\3\2\2\2\u0132"+
		"\u012b\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u013b\3\2\2\2\u0134\u0135\7\7"+
		"\2\2\u0135\u0136\7J\2\2\u0136\u0137\7\6\2\2\u0137\u0138\7\5\2\2\u0138"+
		"\u0139\5 \21\2\u0139\u013a\7\b\2\2\u013a\u013c\3\2\2\2\u013b\u0134\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u0141\3\2\2\2\u013d\u013e\7\7\2\2\u013e"+
		"\u013f\7M\2\2\u013f\u0140\7\6\2\2\u0140\u0142\5&\24\2\u0141\u013d\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0147\3\2\2\2\u0143\u0144\7\7\2\2\u0144"+
		"\u0145\7N\2\2\u0145\u0146\7\6\2\2\u0146\u0148\5*\26\2\u0147\u0143\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7\b\2\2\u014a"+
		"\u014c\7\3\2\2\u014b\u014d\5\6\4\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u014e\3\2\2\2\u014e\u014f\7\4\2\2\u014f\17\3\2\2\2\u0150\u0151"+
		"\7>\2\2\u0151\u0152\7\5\2\2\u0152\u0153\7K\2\2\u0153\u0154\7\6\2\2\u0154"+
		"\u0159\5\u00a4S\2\u0155\u0156\7\7\2\2\u0156\u0157\7?\2\2\u0157\u0158\7"+
		"\6\2\2\u0158\u015a\5h\65\2\u0159\u0155\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015f\3\2\2\2\u015b\u015c\7\7\2\2\u015c\u015d\7U\2\2\u015d\u015e\7\6"+
		"\2\2\u015e\u0160\5\u0094K\2\u015f\u015b\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0165\3\2\2\2\u0161\u0162\7\7\2\2\u0162\u0163\7W\2\2\u0163\u0164\7\6"+
		"\2\2\u0164\u0166\5\u0098M\2\u0165\u0161\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u016b\3\2\2\2\u0167\u0168\7\7\2\2\u0168\u0169\7V\2\2\u0169\u016a\7\6"+
		"\2\2\u016a\u016c\5\u0096L\2\u016b\u0167\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u0171\3\2\2\2\u016d\u016e\7\7\2\2\u016e\u016f\7O\2\2\u016f\u0170\7\6"+
		"\2\2\u0170\u0172\5\24\13\2\u0171\u016d\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u017a\3\2\2\2\u0173\u0174\7\7\2\2\u0174\u0175\7P\2\2\u0175\u0176\7\6"+
		"\2\2\u0176\u0177\7\5\2\2\u0177\u0178\5\22\n\2\u0178\u0179\7\b\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u0173\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0180\3\2"+
		"\2\2\u017c\u017d\7\7\2\2\u017d\u017e\7X\2\2\u017e\u017f\7\6\2\2\u017f"+
		"\u0181\5\u009aN\2\u0180\u017c\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0186"+
		"\3\2\2\2\u0182\u0183\7\7\2\2\u0183\u0184\7M\2\2\u0184\u0185\7\6\2\2\u0185"+
		"\u0187\5&\24\2\u0186\u0182\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018c\3\2"+
		"\2\2\u0188\u0189\7\7\2\2\u0189\u018a\7N\2\2\u018a\u018b\7\6\2\2\u018b"+
		"\u018d\5*\26\2\u018c\u0188\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2"+
		"\2\2\u018e\u018f\7\b\2\2\u018f\u0191\7\3\2\2\u0190\u0192\5\6\4\2\u0191"+
		"\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7\4"+
		"\2\2\u0194\21\3\2\2\2\u0195\u019a\5\60\31\2\u0196\u0197\7\7\2\2\u0197"+
		"\u0199\5\60\31\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3"+
		"\2\2\2\u019a\u019b\3\2\2\2\u019b\23\3\2\2\2\u019c\u019a\3\2\2\2\u019d"+
		"\u019e\5\60\31\2\u019e\25\3\2\2\2\u019f\u01a0\5\60\31\2\u01a0\27\3\2\2"+
		"\2\u01a1\u01a2\5\60\31\2\u01a2\31\3\2\2\2\u01a3\u01a4\7d\2\2\u01a4\33"+
		"\3\2\2\2\u01a5\u01aa\5\60\31\2\u01a6\u01a7\7\7\2\2\u01a7\u01a9\5\60\31"+
		"\2\u01a8\u01a6\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab"+
		"\3\2\2\2\u01ab\35\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01b2\5\60\31\2\u01ae"+
		"\u01af\7\7\2\2\u01af\u01b1\5\60\31\2\u01b0\u01ae\3\2\2\2\u01b1\u01b4\3"+
		"\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\37\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b5\u01ba\5\60\31\2\u01b6\u01b7\7\7\2\2\u01b7\u01b9\5"+
		"\60\31\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb!\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7\5\2\2"+
		"\u01be\u01bf\7K\2\2\u01bf\u01c0\7\6\2\2\u01c0\u01c1\5\u00a4S\2\u01c1\u01c2"+
		"\7\7\2\2\u01c2\u01c3\7L\2\2\u01c3\u01c4\7\6\2\2\u01c4\u01c5\5(\25\2\u01c5"+
		"\u01c6\7\7\2\2\u01c6\u01c7\7M\2\2\u01c7\u01c8\7\6\2\2\u01c8\u01c9\5&\24"+
		"\2\u01c9\u01ca\7\b\2\2\u01ca#\3\2\2\2\u01cb\u01cc\7\5\2\2\u01cc\u01cd"+
		"\7K\2\2\u01cd\u01ce\7\6\2\2\u01ce\u01cf\5\u00a4S\2\u01cf\u01d0\7\7\2\2"+
		"\u01d0\u01d1\7M\2\2\u01d1\u01d2\7\6\2\2\u01d2\u01d3\5&\24\2\u01d3\u01d4"+
		"\7\7\2\2\u01d4\u01d5\7N\2\2\u01d5\u01d6\7\6\2\2\u01d6\u01d7\5*\26\2\u01d7"+
		"\u01d8\7\b\2\2\u01d8%\3\2\2\2\u01d9\u01da\5\u00a8U\2\u01da\'\3\2\2\2\u01db"+
		"\u01dc\5\u00a8U\2\u01dc)\3\2\2\2\u01dd\u01de\t\2\2\2\u01de+\3\2\2\2\u01df"+
		"\u01e0\7\63\2\2\u01e0\u01e1\7\6\2\2\u01e1\u01e2\5\u00a4S\2\u01e2\u01e3"+
		"\7\6\2\2\u01e3\u01e4\5.\30\2\u01e4-\3\2\2\2\u01e5\u01ea\7d\2\2\u01e6\u01e7"+
		"\7\n\2\2\u01e7\u01e9\7d\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea"+
		"\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb/\3\2\2\2\u01ec\u01ea\3\2\2\2"+
		"\u01ed\u01f9\5.\30\2\u01ee\u01ef\7\13\2\2\u01ef\u01f4\5\60\31\2\u01f0"+
		"\u01f1\7\7\2\2\u01f1\u01f3\5\60\31\2\u01f2\u01f0\3\2\2\2\u01f3\u01f6\3"+
		"\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f7\u01f8\7\f\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01ee\3\2"+
		"\2\2\u01f9\u01fa\3\2\2\2\u01fa\61\3\2\2\2\u01fb\u01fc\7\64\2\2\u01fc\u01fd"+
		"\7\6\2\2\u01fd\u01fe\5\u00a4S\2\u01fe\u01ff\7\6\2\2\u01ff\u0200\5.\30"+
		"\2\u0200\u0201\7\6\2\2\u0201\u0202\5\64\33\2\u0202\u0203\7\t\2\2\u0203"+
		"\63\3\2\2\2\u0204\u0205\5\u00a4S\2\u0205\65\3\2\2\2\u0206\u0210\5> \2"+
		"\u0207\u0210\5B\"\2\u0208\u0210\5D#\2\u0209\u0210\5F$\2\u020a\u0210\5"+
		"J&\2\u020b\u0210\5<\37\2\u020c\u0210\5:\36\2\u020d\u0210\58\35\2\u020e"+
		"\u0210\5H%\2\u020f\u0206\3\2\2\2\u020f\u0207\3\2\2\2\u020f\u0208\3\2\2"+
		"\2\u020f\u0209\3\2\2\2\u020f\u020a\3\2\2\2\u020f\u020b\3\2\2\2\u020f\u020c"+
		"\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210\u0213\3\2\2\2\u0211"+
		"\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\67\3\2\2\2\u0213\u0211\3\2\2"+
		"\2\u0214\u0215\7 \2\2\u0215\u0216\7\5\2\2\u0216\u0217\7K\2\2\u0217\u0218"+
		"\7\6\2\2\u0218\u0219\5\u00a4S\2\u0219\u021a\7\7\2\2\u021a\u021b\7F\2\2"+
		"\u021b\u021c\7\6\2\2\u021c\u021d\5\u00a6T\2\u021d\u021e\7\7\2\2\u021e"+
		"\u021f\7\37\2\2\u021f\u0220\7\6\2\2\u0220\u0221\5r:\2\u0221\u0222\7\7"+
		"\2\2\u0222\u0223\7C\2\2\u0223\u0224\7\6\2\2\u0224\u022c\5t;\2\u0225\u0226"+
		"\7\7\2\2\u0226\u0227\7!\2\2\u0227\u0228\7\6\2\2\u0228\u0229\7\5\2\2\u0229"+
		"\u022a\5R*\2\u022a\u022b\7\b\2\2\u022b\u022d\3\2\2\2\u022c\u0225\3\2\2"+
		"\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\7\b\2\2\u022f9"+
		"\3\2\2\2\u0230\u0231\7#\2\2\u0231\u0232\7\5\2\2\u0232\u0233\7K\2\2\u0233"+
		"\u0234\7\6\2\2\u0234\u0235\5\u00a4S\2\u0235\u0236\7\7\2\2\u0236\u0237"+
		"\7F\2\2\u0237\u0238\7\6\2\2\u0238\u0239\5\u00a6T\2\u0239\u023a\7\7\2\2"+
		"\u023a\u023b\7\"\2\2\u023b\u023c\7\6\2\2\u023c\u023d\5b\62\2\u023d\u023e"+
		"\7\7\2\2\u023e\u023f\7$\2\2\u023f\u0240\7\6\2\2\u0240\u0241\5`\61\2\u0241"+
		"\u0242\7\7\2\2\u0242\u0243\7)\2\2\u0243\u0244\7\6\2\2\u0244\u0245\5\u0092"+
		"J\2\u0245\u0246\7\7\2\2\u0246\u0247\7+\2\2\u0247\u0248\7\6\2\2\u0248\u0249"+
		"\5f\64\2\u0249\u024a\7\7\2\2\u024a\u024b\7%\2\2\u024b\u024c\7\6\2\2\u024c"+
		"\u024d\5\u0088E\2\u024d\u024e\7\7\2\2\u024e\u024f\7&\2\2\u024f\u0250\7"+
		"\6\2\2\u0250\u0251\5\u008aF\2\u0251\u0252\7\7\2\2\u0252\u0253\7\'\2\2"+
		"\u0253\u0254\7\6\2\2\u0254\u0255\5j\66\2\u0255\u0256\7\7\2\2\u0256\u0257"+
		"\7(\2\2\u0257\u0258\7\6\2\2\u0258\u0259\5l\67\2\u0259\u025a\7\b\2\2\u025a"+
		";\3\2\2\2\u025b\u025c\7\66\2\2\u025c\u025d\7\5\2\2\u025d\u025e\7K\2\2"+
		"\u025e\u025f\7\6\2\2\u025f\u0260\5\u00a4S\2\u0260\u0261\7\7\2\2\u0261"+
		"\u0262\7F\2\2\u0262\u0263\7\6\2\2\u0263\u0264\5\u00a6T\2\u0264\u0265\7"+
		"\b\2\2\u0265\u0266\7\3\2\2\u0266\u0267\5V,\2\u0267\u0268\7\4\2\2\u0268"+
		"=\3\2\2\2\u0269\u026a\7\65\2\2\u026a\u026b\7\5\2\2\u026b\u026c\7K\2\2"+
		"\u026c\u026d\7\6\2\2\u026d\u026e\5\u00a4S\2\u026e\u026f\7\7\2\2\u026f"+
		"\u0270\7F\2\2\u0270\u0271\7\6\2\2\u0271\u0272\5\u00a6T\2\u0272\u0273\7"+
		"\b\2\2\u0273\u0274\7\3\2\2\u0274\u0275\5@!\2\u0275\u0276\7\4\2\2\u0276"+
		"?\3\2\2\2\u0277\u0278\7^\2\2\u0278A\3\2\2\2\u0279\u027a\7\67\2\2\u027a"+
		"\u027b\7\5\2\2\u027b\u027c\7K\2\2\u027c\u027d\7\6\2\2\u027d\u027e\5\u00a4"+
		"S\2\u027e\u027f\7\7\2\2\u027f\u0280\7F\2\2\u0280\u0281\7\6\2\2\u0281\u0282"+
		"\5\u00a6T\2\u0282\u0283\7\7\2\2\u0283\u0284\5\u0092J\2\u0284\u0285\7\b"+
		"\2\2\u0285\u0286\7\3\2\2\u0286\u0287\5@!\2\u0287\u0288\7\4\2\2\u0288C"+
		"\3\2\2\2\u0289\u028a\78\2\2\u028a\u028b\7\r\2\2\u028b\u028c\7\3\2\2\u028c"+
		"\u028d\5P)\2\u028d\u028e\7\4\2\2\u028eE\3\2\2\2\u028f\u0290\79\2\2\u0290"+
		"\u0291\7\5\2\2\u0291\u0292\7K\2\2\u0292\u0293\7\6\2\2\u0293\u0294\5\u00a4"+
		"S\2\u0294\u0295\7\7\2\2\u0295\u0296\7F\2\2\u0296\u0297\7\6\2\2\u0297\u0298"+
		"\5\u00a6T\2\u0298\u0299\7\7\2\2\u0299\u029a\7)\2\2\u029a\u029b\7\6\2\2"+
		"\u029b\u029c\5\u0092J\2\u029c\u029d\7\b\2\2\u029d\u029e\7\3\2\2\u029e"+
		"\u029f\5L\'\2\u029f\u02a0\7\4\2\2\u02a0G\3\2\2\2\u02a1\u02a2\7:\2\2\u02a2"+
		"\u02a3\7\5\2\2\u02a3\u02a4\7K\2\2\u02a4\u02a5\7\6\2\2\u02a5\u02a6\5\u00a4"+
		"S\2\u02a6\u02a7\7\7\2\2\u02a7\u02a8\7F\2\2\u02a8\u02a9\7\6\2\2\u02a9\u02aa"+
		"\5\u00a6T\2\u02aa\u02ab\7\b\2\2\u02abI\3\2\2\2\u02ac\u02ad\7;\2\2\u02ad"+
		"\u02ae\7\5\2\2\u02ae\u02af\7F\2\2\u02af\u02b0\7\6\2\2\u02b0\u02b1\5\u00a6"+
		"T\2\u02b1\u02b2\7\b\2\2\u02b2K\3\2\2\2\u02b3\u02b8\5N(\2\u02b4\u02b5\7"+
		"\7\2\2\u02b5\u02b7\5N(\2\u02b6\u02b4\3\2\2\2\u02b7\u02ba\3\2\2\2\u02b8"+
		"\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9M\3\2\2\2\u02ba\u02b8\3\2\2\2"+
		"\u02bb\u02bc\7\5\2\2\u02bc\u02bd\7+\2\2\u02bd\u02be\7\6\2\2\u02be\u02bf"+
		"\5f\64\2\u02bf\u02c0\7\7\2\2\u02c0\u02c1\7?\2\2\u02c1\u02c2\7\6\2\2\u02c2"+
		"\u02c3\5h\65\2\u02c3\u02c4\7\7\2\2\u02c4\u02c5\7U\2\2\u02c5\u02c6\7\6"+
		"\2\2\u02c6\u02c7\5\u0094K\2\u02c7\u02c8\7\7\2\2\u02c8\u02c9\7V\2\2\u02c9"+
		"\u02ca\7\6\2\2\u02ca\u02cb\5\u0096L\2\u02cb\u02cc\7\7\2\2\u02cc\u02cd"+
		"\7B\2\2\u02cd\u02ce\7\6\2\2\u02ce\u02cf\5b\62\2\u02cf\u02d0\7\7\2\2\u02d0"+
		"\u02d1\7D\2\2\u02d1\u02d2\7\6\2\2\u02d2\u02d3\5`\61\2\u02d3\u02d4\7\7"+
		"\2\2\u02d4\u02d5\7*\2\2\u02d5\u02d6\7\6\2\2\u02d6\u02d7\5p9\2\u02d7\u02d8"+
		"\7\b\2\2\u02d8O\3\2\2\2\u02d9\u02de\5d\63\2\u02da\u02db\7\7\2\2\u02db"+
		"\u02dd\5d\63\2\u02dc\u02da\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2"+
		"\2\2\u02de\u02df\3\2\2\2\u02dfQ\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1\u02e6"+
		"\5T+\2\u02e2\u02e3\7\7\2\2\u02e3\u02e5\5T+\2\u02e4\u02e2\3\2\2\2\u02e5"+
		"\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7S\3\2\2\2"+
		"\u02e8\u02e6\3\2\2\2\u02e9\u02ea\5v<\2\u02eaU\3\2\2\2\u02eb\u02f0\5X-"+
		"\2\u02ec\u02ed\7\7\2\2\u02ed\u02ef\5X-\2\u02ee\u02ec\3\2\2\2\u02ef\u02f2"+
		"\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1W\3\2\2\2\u02f2"+
		"\u02f0\3\2\2\2\u02f3\u02f4\7\5\2\2\u02f4\u02f5\7E\2\2\u02f5\u02f6\7\6"+
		"\2\2\u02f6\u02f7\5Z.\2\u02f7\u02f8\7\7\2\2\u02f8\u02f9\7V\2\2\u02f9\u02fa"+
		"\7\6\2\2\u02fa\u02fb\5\u0096L\2\u02fb\u02fc\7\7\2\2\u02fc\u02fd\7B\2\2"+
		"\u02fd\u02fe\7\6\2\2\u02fe\u02ff\5\\/\2\u02ff\u0300\7\7\2\2\u0300\u0301"+
		"\7D\2\2\u0301\u0302\7\6\2\2\u0302\u0303\5^\60\2\u0303\u0304\7\b\2\2\u0304"+
		"Y\3\2\2\2\u0305\u0306\7e\2\2\u0306[\3\2\2\2\u0307\u0308\5\60\31\2\u0308"+
		"]\3\2\2\2\u0309\u030a\5v<\2\u030a_\3\2\2\2\u030b\u030c\5v<\2\u030ca\3"+
		"\2\2\2\u030d\u030e\5\60\31\2\u030ec\3\2\2\2\u030f\u0314\7\3\2\2\u0310"+
		"\u0311\7d\2\2\u0311\u0313\7\n\2\2\u0312\u0310\3\2\2\2\u0313\u0316\3\2"+
		"\2\2\u0314\u0312\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0317\3\2\2\2\u0316"+
		"\u0314\3\2\2\2\u0317\u0318\t\3\2\2\u0318\u0319\7\4\2\2\u0319e\3\2\2\2"+
		"\u031a\u031b\7c\2\2\u031bg\3\2\2\2\u031c\u031d\5n8\2\u031di\3\2\2\2\u031e"+
		"\u031f\5n8\2\u031fk\3\2\2\2\u0320\u0321\5n8\2\u0321m\3\2\2\2\u0322\u0323"+
		"\t\4\2\2\u0323o\3\2\2\2\u0324\u0325\5v<\2\u0325q\3\2\2\2\u0326\u0327\5"+
		"v<\2\u0327s\3\2\2\2\u0328\u0329\5v<\2\u0329u\3\2\2\2\u032a\u032e\5x=\2"+
		"\u032b\u032e\5\u008cG\2\u032c\u032e\5~@\2\u032d\u032a\3\2\2\2\u032d\u032b"+
		"\3\2\2\2\u032d\u032c\3\2\2\2\u032ew\3\2\2\2\u032f\u0332\5z>\2\u0330\u0332"+
		"\5|?\2\u0331\u032f\3\2\2\2\u0331\u0330\3\2\2\2\u0332y\3\2\2\2\u0333\u0334"+
		"\7\23\2\2\u0334\u0335\7\24\2\2\u0335\u0336\7\n\2\2\u0336\u0337\7\25\2"+
		"\2\u0337\u0338\7\5\2\2\u0338\u0339\5\u0080A\2\u0339\u033a\7\b\2\2\u033a"+
		"\u033b\7\23\2\2\u033b{\3\2\2\2\u033c\u033d\7\23\2\2\u033d\u033e\7\24\2"+
		"\2\u033e\u033f\7\n\2\2\u033f\u0340\7\26\2\2\u0340\u0341\7\5\2\2\u0341"+
		"\u0342\5\u0080A\2\u0342\u0343\7\b\2\2\u0343\u0344\7\27\2\2\u0344\u0345"+
		"\5\u0082B\2\u0345\u0346\7\30\2\2\u0346\u0347\7\23\2\2\u0347}\3\2\2\2\u0348"+
		"\u0349\t\5\2\2\u0349\177\3\2\2\2\u034a\u034b\7d\2\2\u034b\u0081\3\2\2"+
		"\2\u034c\u034d\7e\2\2\u034d\u0083\3\2\2\2\u034e\u034f\bC\1\2\u034f\u0350"+
		"\7d\2\2\u0350\u0352\7\5\2\2\u0351\u0353\5\u0086D\2\u0352\u0351\3\2\2\2"+
		"\u0352\u0353\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0367\7\b\2\2\u0355\u0356"+
		"\7d\2\2\u0356\u0357\7\27\2\2\u0357\u0358\5\u0084C\2\u0358\u0359\7\30\2"+
		"\2\u0359\u0367\3\2\2\2\u035a\u035b\7\33\2\2\u035b\u0367\5\u0084C\f\u035c"+
		"\u035d\7\34\2\2\u035d\u0367\5\u0084C\13\u035e\u0367\5\u008eH\2\u035f\u0367"+
		"\5\u008cG\2\u0360\u0361\7\5\2\2\u0361\u0362\5\u0084C\2\u0362\u0363\7\b"+
		"\2\2\u0363\u0367\3\2\2\2\u0364\u0367\7\32\2\2\u0365\u0367\7\31\2\2\u0366"+
		"\u034e\3\2\2\2\u0366\u0355\3\2\2\2\u0366\u035a\3\2\2\2\u0366\u035c\3\2"+
		"\2\2\u0366\u035e\3\2\2\2\u0366\u035f\3\2\2\2\u0366\u0360\3\2\2\2\u0366"+
		"\u0364\3\2\2\2\u0366\u0365\3\2\2\2\u0367\u0373\3\2\2\2\u0368\u0369\f\n"+
		"\2\2\u0369\u036a\7\16\2\2\u036a\u0372\5\u0084C\13\u036b\u036c\f\t\2\2"+
		"\u036c\u036d\t\6\2\2\u036d\u0372\5\u0084C\n\u036e\u036f\f\b\2\2\u036f"+
		"\u0370\7\36\2\2\u0370\u0372\5\u0084C\t\u0371\u0368\3\2\2\2\u0371\u036b"+
		"\3\2\2\2\u0371\u036e\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0373"+
		"\u0374\3\2\2\2\u0374\u0085\3\2\2\2\u0375\u0373\3\2\2\2\u0376\u037b\5\u0084"+
		"C\2\u0377\u0378\7\7\2\2\u0378\u037a\5\u0084C\2\u0379\u0377\3\2\2\2\u037a"+
		"\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u0087\3\2"+
		"\2\2\u037d\u037b\3\2\2\2\u037e\u037f\7c\2\2\u037f\u0089\3\2\2\2\u0380"+
		"\u0381\7c\2\2\u0381\u008b\3\2\2\2\u0382\u0383\7g\2\2\u0383\u008d\3\2\2"+
		"\2\u0384\u0385\7f\2\2\u0385\u008f\3\2\2\2\u0386\u0387\7c\2\2\u0387\u0091"+
		"\3\2\2\2\u0388\u0389\7c\2\2\u0389\u0093\3\2\2\2\u038a\u038b\7c\2\2\u038b"+
		"\u0095\3\2\2\2\u038c\u038d\7c\2\2\u038d\u0097\3\2\2\2\u038e\u038f\7c\2"+
		"\2\u038f\u0099\3\2\2\2\u0390\u0391\7c\2\2\u0391\u009b\3\2\2\2\u0392\u0393"+
		"\7c\2\2\u0393\u009d\3\2\2\2\u0394\u0395\7c\2\2\u0395\u009f\3\2\2\2\u0396"+
		"\u0397\t\7\2\2\u0397\u00a1\3\2\2\2\u0398\u0399\7_\2\2\u0399\u00a3\3\2"+
		"\2\2\u039a\u039b\7d\2\2\u039b\u00a5\3\2\2\2\u039c\u039d\7d\2\2\u039d\u00a7"+
		"\3\2\2\2\u039e\u039f\t\b\2\2\u039f\u00a9\3\2\2\2\u03a0\u03a1\t\t\2\2\u03a1"+
		"\u00ab\3\2\2\2\67\u00bd\u00bf\u00cb\u00d6\u00dc\u00e2\u00eb\u00f1\u00ff"+
		"\u0105\u010b\u0111\u0117\u011d\u0123\u0129\u0132\u013b\u0141\u0147\u014c"+
		"\u0159\u015f\u0165\u016b\u0171\u017a\u0180\u0186\u018c\u0191\u019a\u01aa"+
		"\u01b2\u01ba\u01ea\u01f4\u01f9\u020f\u0211\u022c\u02b8\u02de\u02e6\u02f0"+
		"\u0314\u032d\u0331\u0352\u0366\u0371\u0373\u037b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}