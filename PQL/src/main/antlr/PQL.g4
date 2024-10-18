grammar PQL;

@header {
    package mil.darpa.immortals.core.das.pql.generated;
} 

prog:								WHEN '{' rootFragment '}' THEN '{' commands '}';
rootFragment:						FRAGMENT rootFragmentOptions '{' codeOrFragmentPatterns '}';
codeOrFragmentPatterns:				(fragmentPattern | codePattern)+;
fragmentPattern:					FRAGMENT fragmentOptions '{' codeOrFragmentPatterns '}';
codePattern:						referenceSearch | methodInvocation | classDeclaration | methodDeclaration;

methodInvocation:					METHOD_INVOCATION '(' ID ':' bindingDecl 
									(',' RECEIVER_TYPE ':' receiverType)? 
									(',' METHOD_NAME ':' methodName)? 
									(',' PATTERN_CONTEXT ':' patternContext)? 
									(',' ARGUMENT_TYPES ':' '(' argumentTypes ')')? 
									(',' DUPLICATE_POLICY ':' duplicatePolicy)? 
									')' 
									';';

methodDeclaration:					METHOD_DECLARATION '(' ID ':' bindingDecl 
									(',' ACCESS_MODIFIER ':' accessModifier)?
									(',' STATIC_MODIFIER ':' staticModifier)?
									(',' ABSTRACT_MODIFIER ':' abstractModifier)?
									(',' FINAL_MODIFIER ':' finalModifier)?
									(',' NATIVE_MODIFIER ':' nativeModifier)?
									(',' SYNCHRONIZED_MODIFIER ':' synchronizedModifier)?
									(',' RETURN_TYPE ':' returnType)?
									(',' METHOD_NAME ':' methodName)?
									(',' PARAMETER_TYPES ':' '(' parameterTypes ')')?
									(',' THROWS_TYPES ':' '(' throwsTypes ')')?
									(',' CHILD_SEARCH_POLICY ':' childSearchPolicy)?
									(',' DUPLICATE_POLICY ':' duplicatePolicy)? 
									')'
									'{' codeOrFragmentPatterns? '}'
									;
									
classDeclaration:					CLASS_DECLARATION '(' ID ':' bindingDecl 
									(',' ACCESS_MODIFIER ':' accessModifier)? 
									(',' STATIC_MODIFIER ':' staticModifier)? 
									(',' ABSTRACT_MODIFIER ':' abstractModifier)?
									(',' FINAL_MODIFIER ':' finalModifier)? 
									(',' SUPERCLASS_TYPE ':' superClassType)? 
									(',' INTERFACE_TYPES ':' '(' interfaceTypes ')')? 
									(',' NESTED_CLASS ':' nestedClass)?
									(',' CHILD_SEARCH_POLICY ':' childSearchPolicy)?
									(',' DUPLICATE_POLICY ':' duplicatePolicy)? 
									')' 
									'{' codeOrFragmentPatterns? '}'
									;

interfaceTypes:						genericizedType (',' genericizedType)*;
superClassType:						genericizedType;
receiverType:						genericizedType;
returnType:							genericizedType;
methodName:							IDENTIFIER;
argumentTypes:						genericizedType (',' genericizedType)*;
parameterTypes:						genericizedType (',' genericizedType)*;
throwsTypes:						genericizedType (',' genericizedType)*;
rootFragmentOptions:				'(' ID ':' bindingDecl ',' FRAGMENT_SEARCH_POLICY ':' fragmentSearchPolicy ',' CHILD_SEARCH_POLICY ':' childSearchPolicy ')';
fragmentOptions:					'(' ID ':' bindingDecl ',' CHILD_SEARCH_POLICY ':' childSearchPolicy ',' DUPLICATE_POLICY ':' duplicatePolicy ')';
childSearchPolicy:					searchPolicy;
fragmentSearchPolicy:				searchPolicy;
duplicatePolicy:					HALT_ON_DUPLICATE | SEARCH_NEXT_UNIQUE | CYCLE_CHILDREN;
reference:							REFERENCE ':' bindingDecl ':' type;
type:								IDENTIFIER ('.' IDENTIFIER)*;
genericizedType:					type ('<' genericizedType (',' genericizedType)* '>')?;

referenceSearch:					REFERENCE_SEARCH ':' bindingDecl ':' type ':' anchor ';';
anchor:								bindingDecl;

commands:							(replace | addMethod | addImports | addFields | printMatch | addParameters | addGetterSetter | addMethodInvocation | desugarMethodInvocation)*;

addMethodInvocation:				ADD_METHOD_INVOCATION '(' ID ':' bindingDecl ','
									TARGET_ID ':' targetBinding ','
									RECEIVER ':' receiver ','
									METHOD_NAME ':' methodToInvoke
									(',' ARGUMENTS ':' '(' arguments ')')?
									')';

addGetterSetter:					ADD_GETTER_SETTER '(' ID ':' bindingDecl ',' 
									TARGET_ID ':' targetBinding ','
									FIELD_TYPE ':' fieldType ','
									FIELD_NAME ':' fieldName ',' 
									APPLY_TO_ANCESTOR_CLASS ':' applyToAncestorClass ','
									IDEMPOTENT ':' idempotent ',' 
									ADD_GETTER ':' addGetter ',' 
									ADD_SETTER ':' addSetter ','
									GETTER_ACCESS_MODIFIER ':' getterAccessModifier ',' 
									SETTER_ACCESS_MODIFIER ':' setterAccessModifier
									')';

addParameters:						ADD_PARAMETERS '(' ID ':' bindingDecl ',' TARGET_ID ':' targetBinding ')' '{' parameters '}';
replace:							REPLACE '(' ID ':' bindingDecl ',' TARGET_ID ':' targetBinding ')' '{' codeBlock '}';
codeBlock:							CODE_BLOCK;

addMethod:							ADD_METHOD '(' ID ':' bindingDecl ',' TARGET_ID ':' targetBinding ',' applyToAncestorClass ')' '{' codeBlock '}';
addImports:							ADD_IMPORTS '()' '{' imports '}';

addFields:							ADD_FIELDS '(' ID ':' bindingDecl ',' TARGET_ID ':' targetBinding ',' 
									APPLY_TO_ANCESTOR_CLASS ':' applyToAncestorClass ')' '{' fields '}';

desugarMethodInvocation:			DESUGAR_METHOD_INVOCATION '(' ID ':' bindingDecl ',' TARGET_ID ':' targetBinding ')';

printMatch:							PRINT_MATCH '(' TARGET_ID ':' targetBinding ')';

fields:								field (',' field)*;

field:								'(' IDEMPOTENT ':' idempotent ',' 
									ACCESS_MODIFIER ':' accessModifier ',' 
									STATIC_MODIFIER ':' staticModifier ',' 
									FINAL_MODIFIER ':' finalModifier ','
									TYPE ':' fieldType ','
									NAME ':' fieldName ','
									INITIALIZER ':' initializer ')';

imports:							importType (',' importType)*;

arguments:							argument (',' argument)*;
argument:							pqlExpression;

parameters:							parameter (',' parameter)*;
parameter:							'(' ADD_AFTER_POSITION ':' parameterPosition
									',' FINAL_MODIFIER ':' finalModifier
									',' TYPE ':' parameterType
									',' NAME ':' parameterName ')';
parameterPosition:					INT_LITERAL;
parameterType:						genericizedType;
parameterName:						pqlExpression;
fieldName:							pqlExpression;
fieldType:							genericizedType;

importType:							'{' (IDENTIFIER '.')* (IDENTIFIER | '*') '}';

idempotent:							BOOL_LITERAL;
accessModifier:						scope;
getterAccessModifier:				scope;
setterAccessModifier:				scope;
scope:								'Public' | 'Private' | 'Protected' | 'PackageLevel';

initializer:						pqlExpression;
receiver:							pqlExpression;
methodToInvoke:						pqlExpression;

pqlExpression:						contextReferences | stringLiteral | nameExpression;

contextReferences:					(stringContextReference | stringArrayContextReference);

stringContextReference:				'`' 'Context' '.' 'getString' '(' bindingLookup ')' '`';
stringArrayContextReference:		'`' 'Context' '.' 'getStringArray' '(' bindingLookup ')' '[' lookupIndex ']' '`';
nameExpression:						IDENTIFIER | 'null' | 'this';

bindingLookup:						IDENTIFIER;
lookupIndex:						INT_LITERAL;

expression:							IDENTIFIER '(' expressions? ')'												#function_call
									| IDENTIFIER '[' expression ']'												#array_reference
									| '-' expression															#unary_minus
									| '!' expression															#negation
									| expression '*' expression													#multiplication
									| expression ('+' | '-') expression											#addition_subtraction
									| expression '==' expression												#equality
									| decimalLiteral															#decimal
									| stringLiteral																#string
									| '(' expression ')'														#parenthesized_expr
									| 'this'																	#this
									| 'null'																	#null
									;
							
expressions:						expression (',' expression)*;

addGetter:							BOOL_LITERAL;
addSetter:							BOOL_LITERAL;

stringLiteral:						STRING_LITERAL;
decimalLiteral:						DECIMAL_LITERAL;		
booleanLiteral:						BOOL_LITERAL;
applyToAncestorClass:				BOOL_LITERAL;
staticModifier:						BOOL_LITERAL;
finalModifier:						BOOL_LITERAL;
abstractModifier:					BOOL_LITERAL;
nestedClass:						BOOL_LITERAL;
nativeModifier:						BOOL_LITERAL;
synchronizedModifier:				BOOL_LITERAL;

order:								ORDERED | UNORDERED;
bindingRef:							BINDING_REF;
bindingDecl:						IDENTIFIER;
targetBinding:						IDENTIFIER;
searchPolicy:						RESTART_AT_HOME | RESTART_AT_END_LAST_MATCH;
patternContext:						EXPRESSION | STATEMENT;

//Keywords

RECEIVER:							'Receiver';
ADD_METHOD_INVOCATION:				'addMethodInvocation';
ARGUMENTS:							'Arguments';
FIELD_TYPE:							'FieldType';
ADD_GETTER_SETTER:					'addGetterSetter';
FIELD_NAME:							'FieldName';
ADD_GETTER:							'AddGetter';
ADD_SETTER:							'AddSetter';
GETTER_ACCESS_MODIFIER:				'GetterAccessModifier';
SETTER_ACCESS_MODIFIER:				'SetterAccessModifier';
APPLY_TO_ANCESTOR_CLASS:			'ApplyToAncestorClass';
INITIALIZER:						'Initializer';
IDEMPOTENT:							'Idempotent';
WHEN:								'when';
FRAGMENT:							'fragment';
THEN:								'then';
STRINGENT:							'stringent';
LENIENT:							'lenient';
ORDERED:							'ordered';
UNORDERED:							'unordered';
REFERENCE:							'reference';
REFERENCE_SEARCH:					'referenceSearch';
REPLACE:							'replace';
ADD_PARAMETERS:						'addParameters';
ADD_METHOD:							'addMethod';
ADD_IMPORTS:						'addImports';
ADD_FIELDS:							'addFields';
DESUGAR_METHOD_INVOCATION:			'desugarMethodInvocation';
PRINT_MATCH:						'printMatch';
METHOD_INVOCATION:					'methodInvocation';
METHOD_DECLARATION:					'methodDeclaration';
CLASS_DECLARATION:					'classDeclaration';
ACCESS_MODIFIER:					'AccessModifier';
RECEIVER_TYPE:						'ReceiverType';
RETURN_TYPE:						'ReturnType';
TYPE:								'Type';
METHOD_NAME:						'MethodName';
NAME:								'Name';
ADD_AFTER_POSITION:					'AddAfterPosition';
TARGET_ID:							'TargetID';
PATTERN_CONTEXT:					'PatternContext';
ARGUMENT_TYPES:						'ArgumentTypes';
PARAMETER_TYPES:					'ParameterTypes';
THROWS_TYPES:						'ThrowsTypes';
ID:									'ID';
FRAGMENT_SEARCH_POLICY:				'FragmentSearchPolicy';
CHILD_SEARCH_POLICY:				'ChildSearchPolicy';
DUPLICATE_POLICY:					'DuplicatePolicy';
SUPERCLASS_TYPE:					'SuperClassType';
INTERFACE_TYPES:					'InterfaceTypes';
RESTART_AT_HOME:					'RestartAtHome';
RESTART_AT_END_LAST_MATCH:			'RestartAtEndLastMatch';
EXPRESSION:							'Expression';
STATEMENT:							'Statement';
STATIC_MODIFIER:					'StaticModifier';
FINAL_MODIFIER:						'FinalModifier';
ABSTRACT_MODIFIER:					'AbstractModifier';
NESTED_CLASS:						'Nested';
NATIVE_MODIFIER:					'NativeModifier';
SYNCHRONIZED_MODIFIER:				'SynchronizedModifier';
HALT_ON_DUPLICATE:					'HaltOnDuplicate';
SEARCH_NEXT_UNIQUE:					'SearchNextUnique';
CYCLE_CHILDREN:						'CycleChildren';

CODE_BLOCK:							'@#' .*? '#@';
BINDING_REF:						'@$' IDENTIFIER;

WS:									[ \t\r\n]+ -> skip ;
COMMENT:							'/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:						'//' ~[\r\n]*    -> channel(HIDDEN);

BOOL_LITERAL:						'true' | 'false' | 'True' | 'False' | 'TRUE' | 'FALSE';
IDENTIFIER:							Letter LetterOrDigit*;
INT_LITERAL:						Digits;

DECIMAL_LITERAL:					('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
STRING_LITERAL:						'"' (~["\\\r\n] | EscapeSequence)* '"';

//Fragments

fragment LetterOrDigit:				Letter | [0-9];
fragment Letter:					[a-zA-Z_];
fragment Digits:					[0-9] ([0-9_]* [0-9])?;
fragment HexDigit:					[0-9a-fA-F];
fragment EscapeSequence:			'\\' [btnfr"'\\] | '\\' ([0-3]? [0-7])? [0-7] | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit;
