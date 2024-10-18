package mil.darpa.immortals.core.das.pql.selectors;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.Statement;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodInvocation;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaObject;
import mil.darpa.immortals.core.das.pql.exceptions.InvalidOrMissingParameters;

public class MethodInvocationSelector extends AbstractSelector<JavaMethodInvocation> {

	@Override
	public Optional<JavaMethodInvocation> select(PQLContext context, Optional<Position> after,
			Optional<CodeArtifact> parentCodeArtifact) {

		if (context == null) {
			throw new InvalidOrMissingParameters("context");
		}

		Optional<JavaMethodInvocation> methodInvocation = Optional.empty();

		Optional<MethodCallExpr> methodCall = Optional.empty();
		
		lastPosition = after;
		
		while (true) {
			methodCall = context.getCompilationUnit().findFirst(MethodCallExpr.class, 
					t -> (methodName.isPresent() ? (t.getNameAsString().equals(methodName.get())) : true)
					&& (argumentTypes.isPresent() ? (isMethodSignatureMatching(context, t, argumentTypes.get().toArray(new String[0]), context.getTypeSolver())) : true)
					&&	t.getBegin().filter(p -> p.isAfter(lastPosition.orElse(Position.HOME))).isPresent());

			if (!methodCall.isPresent()) {
				break;
			}
			
			lastPosition = methodCall.get().getEnd();
			
			//First determine if pql program is filtering on receiver type
			if (receiverType.isPresent()) {
				if (methodCall.get().getScope().isPresent()) {
					//Static analysis is constrained by dynamic dispatch; e.g., we don't know the actual types
					//of method invocation receivers until the program is run. This works out fine since PQL
					//queries are questions about the code as a static resource (i.e., the code on disk versus
					//the program's runtime behavior). So in the case of method invocations
					//we are querying for the *declared* type of a method receiver.
					Expression receiver = methodCall.get().getScope().get();
					if (!isExpressionOfType(context, receiver, this.receiverType.get(), context.getTypeSolver())) {
						continue;
					}
				} else {
					//Next set of steps requires arguments and method name to be provided; since pql program indicates
					//a receiver type, if these are not provided, the receiver type is considered unresolved and we move to next match
					if (!this.methodName.isPresent() || !this.argumentTypes.isPresent()) {
						continue;
					}
					
					//There is no explicit receiver in the code (e.g., a class instance or static method is being invoked from somewhere
					//in the class hierarchy). The implicit receiver is 'this', which has no declared type. So how do we
					//interpret the PQL user's filter on the receiver? We can compare the PQL user's provided type
					//constraint with the class where the method invocation is found (or it's outer class in case the invocation
					//is contained in an inner class). This should cover static and instance method declarations.
					//The type of the actual receiver at runtime may be anywhere in the target class's hierarchy.
					Optional<ClassOrInterfaceDeclaration> targetClass = methodCall.get().findAncestor(ClassOrInterfaceDeclaration.class);
					
					boolean typeResolved = false;
					while (targetClass.isPresent()) {
						//Does class declare the method with same signature?
						Optional<MethodDeclaration> methodDeclaration = targetClass.get().findFirst(MethodDeclaration.class,
								t -> t.getName().asString().equals(this.methodName.get()) &&
								isMethodSignatureMatching(context, t, argumentTypes.get().toArray(new String[0]), context.getTypeSolver()));
						if (methodDeclaration.isPresent()) {
							typeResolved = targetClass.get().getFullyQualifiedName().get().equals(this.receiverType.get());
							break;
						} else {
							if (targetClass.get().isInnerClass() || targetClass.get().isStatic()) {
								targetClass = targetClass.get().findAncestor(ClassOrInterfaceDeclaration.class);
							} else {
								break;
							}
						}
					}
					if (!typeResolved) {
						continue;
					}
				}
			}
	
			if (getPatternContext().isPresent()) {
				if (getPatternContext().get() == PatternContext.Statement) {
					if (!methodCall.get().getParentNode().filter(p -> p instanceof Statement).isPresent()) {
						continue;
					}
				} else if (getPatternContext().get() == PatternContext.Expression) {
					if (!methodCall.get().getParentNode().filter(p -> p instanceof Expression).isPresent()) {
						continue;
					}
				}
			}
			
			if (parentCodeArtifact.isPresent()) {
				boolean isChildOfParent = methodCall.get().isDescendantOf(parentCodeArtifact.get().getSourceNode().get());
				if (!isChildOfParent) {
					continue;
				}
			}
			
			break;
		}
		
		if (!methodCall.isPresent()) {
			return methodInvocation;
		}

		JavaClass javaClass = new JavaClass(context);
		//ForUpdate
		//javaClass.setClassDeclaration(methodCall.get().getAncestorOfType(ClassOrInterfaceDeclaration.class).get());
		javaClass.setClassDeclaration(methodCall.get().findAncestor(ClassOrInterfaceDeclaration.class).get());

		JavaObject javaObject = null;
		if (methodCall.get().getChildNodes().get(0) instanceof NameExpr) {
			javaObject = new JavaObject(context);
			javaObject.setNameExpression((NameExpr) methodCall.get().getChildNodes().get(0));
			javaObject.setAncestorClass(javaClass);
		}
		
		JavaMethodInvocation jm = new JavaMethodInvocation(context);
		jm.setMethodCallExpr(methodCall.get());
		jm.setAncestorClass(javaClass);
		
		jm.setTargetObjectReceiver(javaObject);
		methodInvocation = Optional.of(jm);
		
		//Below pattern context lines of code need some more work
		boolean isParentAStatement = methodCall.get().getParentNode().filter(p -> p instanceof Statement).isPresent();
		 
		if (isParentAStatement) {
			jm.setPatternContext(PatternContext.Statement);
			jm.setMethodCallStatement(methodCall.get().findAncestor((Statement.class)).get());
		} else {
			jm.setPatternContext(PatternContext.Expression);
		}
		
		return methodInvocation;
	}

	public void setReceiverType(Optional<String> receiverType) {
		this.receiverType = receiverType;
	}
	
	public void setMethodName(Optional<String> methodName) {
		this.methodName = methodName;
	}

	public void setArgumentTypes(Optional<List<String>> argumentTypes) {
		this.argumentTypes = argumentTypes;
	}

	private Optional<String> receiverType;
	private Optional<String> methodName;
	private Optional<List<String>> argumentTypes;
	private Optional<Position> lastPosition;
	
}
