package mil.darpa.immortals.core.das.pql.selectors;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;

public abstract class AbstractSelector<T extends CodeArtifact> implements Selector<T> {

	public abstract Optional<T> select(PQLContext context, Optional<Position> after, Optional<CodeArtifact> parentCodeArtifact);

	protected boolean isExpressionOfType(PQLContext context, Expression expr, String type, TypeSolver typeSolver) {
		
		boolean result = false;
		
		try {
			if (expr != null && type != null && type.trim().length() > 0) {
				if (expr.isLiteralExpr()) {
					if (expr.isIntegerLiteralExpr()) {
						result = type.equals("int");
					} else if (expr.isBooleanLiteralExpr()) {
						result = type.equals("boolean");
					} else if (expr.isCharLiteralExpr()) {
						result = type.equals("char");
					} else if (expr.isDoubleLiteralExpr()) {
						result = type.equals("double");
					} else if (expr.isLiteralStringValueExpr()) {
						result = type.equals("java.lang.String");
					} else if (expr.isLongLiteralExpr()) {
						result = type.equals("long");
					} else if (expr.isNullLiteralExpr()) {
						result = type.equals("null");
					} else if (expr.isStringLiteralExpr()) {
						result = type.equals("java.lang.String");
					}
				} else {
					try {
						result = expr.calculateResolvedType().describe().equals(type);
					} catch (Exception e) {
						result = false;
						context.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", type, context.getCompilationUnitFileName()));
					}
					//result = (JavaParserFacade.get(typeSolver).solve(expr).
					//	.getCorrespondingDeclaration().getType().describe()).equalsIgnoreCase(typeName);
					//contextValue = new ContextValue(ContextValueType.NameExpression, expr.asNameExpr().getNameAsString());
				}
			}
		} catch (Exception e) {
			result = false;
		}			
		
		return result;
	}
	
	protected boolean isMethodSignatureMatching(PQLContext context, MethodCallExpr methodCall, String[] argumentTypes, TypeSolver typeSolver) {
		
		boolean result = false;
		int bindingIndex = 0;

		try {
			if (methodCall.getArguments().size() == argumentTypes.length) {
				boolean typeMismatch = false;
				for (Expression arg : methodCall.getArguments()) {
					if (!isExpressionOfType(context, arg, argumentTypes[bindingIndex++], typeSolver)) {
						typeMismatch = true;
						break;
					}
				}
				result = !typeMismatch;
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		
		
		return result;
	}
	
	protected boolean isExtendingType(PQLContext pqlContext, ClassOrInterfaceDeclaration cdt, String superClassType, TypeSolver typeSolver) {
		
		boolean result = false;

		if (superClassType == null || superClassType.trim().equals("java.lang.Object")) {
			result = true;
		} else {
			NodeList<ClassOrInterfaceType> extendedTypes = cdt.getExtendedTypes();
			for (ClassOrInterfaceType xcdt : extendedTypes) {
				ResolvedReferenceType rrt = null;
				
				try {
					rrt = xcdt.resolve();
				} catch (Exception e) {
					rrt = null;
					pqlContext.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", xcdt.getNameAsString(), 
							pqlContext.getCompilationUnitFileName()));
				}
				
				if (rrt != null) {
					result = (rrt.describe().equals(superClassType));
					if (!result) {
						for (ResolvedReferenceType rrtAncestor : rrt.getAllAncestors()) {
							result = (rrtAncestor.describe().equals(superClassType));
							if (result) break;
						}
						if (result) break;
					} else {
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	protected boolean isImplementingTypes(PQLContext pqlContext, ClassOrInterfaceDeclaration cdt, List<String> interfaceTypes, TypeSolver typeSolver) {
		
		boolean result = false;
		boolean interfaceIsResolved = false;
		
		if (interfaceTypes == null || interfaceTypes.isEmpty()) {
			result = true;
		} else {
			for (String interfaceType : interfaceTypes) {
				interfaceIsResolved = false;
				if (interfaceType == null || interfaceType.trim().equals("java.lang.Object")) {
					interfaceIsResolved = true;
				} else {
					NodeList<ClassOrInterfaceType> implementedTypes = cdt.getImplementedTypes();
					if (implementedTypes != null) {
						for (ClassOrInterfaceType xcdt : implementedTypes) {
							ResolvedReferenceType rrt = null;
							try {
								rrt = xcdt.resolve();
							} catch (Exception e) {
								rrt = null;
								pqlContext.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", xcdt.getNameAsString(), 
										pqlContext.getCompilationUnitFileName()));
							}
							if (rrt != null) {
								interfaceIsResolved = (rrt.describe().equals(interfaceType));
								if (!interfaceIsResolved) {
									try {
										for (ResolvedReferenceType rrtAncestor : rrt.getAllAncestors()) {
											interfaceIsResolved = (rrtAncestor.describe().equals(interfaceType));
											if (interfaceIsResolved) break;
										}
									} catch (Exception e) {
										pqlContext.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", rrt.toString(), 
												pqlContext.getCompilationUnitFileName()));
									}
									if (interfaceIsResolved) break;
								} else {
									break;
								}
							}
						}
					}
				}
				if (!interfaceIsResolved) break;
			}
			result = interfaceIsResolved;
		}
		
		return result;
	}
	
	protected boolean hasReturnType(PQLContext pqlContext, MethodDeclaration md, String returnType, TypeSolver typeSolver) {
		
		boolean result = false;
		
		if (returnType == null) {
			result = false;
		} else {
			String type = null;
			try {
				//PQL users should specify void using java.lang.Void
				type = md.getType().resolve().describe();
				if (type.equals("void") && returnType.equals("java.lang.Void")) {
					result = true;
				} else {
					result = type.equals(returnType);
				}
			} catch (Exception e) {
				result = false;
				pqlContext.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", type, 
						pqlContext.getCompilationUnitFileName()));
			}
		}
		
		return result;
	}

	protected boolean isMethodSignatureMatching(PQLContext context, MethodDeclaration methodDeclaration, 
			String[] argumentTypes, TypeSolver typeSolver) {
		
		boolean result = true;
		int bindingIndex = 0;
		String resolvedType = null;
		
		try {
			if (methodDeclaration.getParameters().size() == argumentTypes.length) {
				for (Parameter p : methodDeclaration.getParameters()) {
					try {
						resolvedType = p.resolve().getType().describe();
						if (resolvedType != null) resolvedType = resolvedType.replace(" ", "");
						if (!resolvedType.equals(argumentTypes[bindingIndex++])) {
							result = false;
							break;
						}
					} catch (Exception e) {
						result = false;
						context.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", p.getNameAsString(),
								context.getCompilationUnitFileName()));
						break;
					}
				}
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			//do nothing; return failed match
		}
		
		return result;
	}

	protected boolean isThrowsTypesMatching(PQLContext context, MethodDeclaration methodDeclaration, 
			String[] throwsTypes, TypeSolver typeSolver) {
		
		boolean result = true;
		int bindingIndex = 0;

		try {
			if (methodDeclaration.getThrownExceptions().size() == throwsTypes.length) {
				for (ReferenceType rt : methodDeclaration.getThrownExceptions()) {
					try {
						if (!rt.resolve().describe().equals(throwsTypes[bindingIndex++])) {
							result = false;
							break;
						}
					} catch (Exception e) {
						result = false;
						context.getPqlExecutionResult().addMessage(String.format("Could not resolve symbol: %s in file: %s", rt.toString(),
								context.getCompilationUnitFileName()));
						break;
					}
				}
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			//do nothing; return failed match
		}
		
		return result;
	}
	
	public String getSymbolOfType(PQLContext context, String type, Statement fromStatement) {
		
		String result = null;
		
		SymbolReference<? extends ResolvedValueDeclaration> sr = 
				JavaParserFacade.get(context.getTypeSolver()).getSymbolSolver().solveSymbol("context", fromStatement);
		
		result = sr.getCorrespondingDeclaration().getName();
		
		return result;
		
	}

	@Override
	public void setPatternContext(Optional<PatternContext> patternContext) {
		this.patternContext = patternContext;
	}

	@Override
	public Optional<PatternContext> getPatternContext() {
		return patternContext;
	}

	private Optional<PatternContext> patternContext;
	
}
