package mil.darpa.immortals.core.das.pql.selectors;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.exceptions.InvalidOrMissingParameters;

public class MethodDeclarationSelector extends AbstractSelector<JavaMethodDeclaration> {

	@Override
	public Optional<JavaMethodDeclaration> select(PQLContext context, Optional<Position> after,
			Optional<CodeArtifact> parentCodeArtifact) {

		if (context == null) {
			throw new InvalidOrMissingParameters("context");
		}

		Optional<JavaMethodDeclaration> result = Optional.empty();

		Optional<MethodDeclaration> methodDeclaration = Optional.empty();

		lastPosition = after;
		
		while (true) {
			methodDeclaration = context.getCompilationUnit().findFirst(MethodDeclaration.class, 
						t -> (accessModifier.isPresent() ? (Modifier.isEqual(t.getAccessSpecifier(), accessModifier.get())) : true)
						&& (staticModifier.isPresent() ? (t.isStatic() == staticModifier.get()) : true)
						&& (abstractModifier.isPresent() ? (t.isAbstract() == abstractModifier.get()) : true)
						&& (finalModifier.isPresent() ? (t.isFinal() == finalModifier.get()) : true)
						&& (nativeModifier.isPresent() ? (t.isNative() == nativeModifier.get()) : true)
						&& (synchronizedModifier.isPresent() ? (t.isSynchronized() == synchronizedModifier.get()) : true)
						&& (returnType.isPresent() ? (hasReturnType(context, t, returnType.get(), context.getTypeSolver())) : true)
						&& (methodName.isPresent() ? (t.getNameAsString().equals(methodName.get())) : true)
						&& (parameterTypes.isPresent() ? (isMethodSignatureMatching(context, t, parameterTypes.get().toArray(new String[0]), context.getTypeSolver())) : true)
						&& (throwsTypes.isPresent() ? (isThrowsTypesMatching(context, t, throwsTypes.get().toArray(new String[0]), context.getTypeSolver())) : true)
						&& t.getBegin().filter(p -> p.isAfter(lastPosition.orElse(Position.HOME))).isPresent());
	
			if (!methodDeclaration.isPresent()) {
				break;
			}
			
			lastPosition = methodDeclaration.get().getEnd();
			
			if (parentCodeArtifact.isPresent()) {
				boolean isChildOfParent = methodDeclaration.get().isDescendantOf(parentCodeArtifact.get().getSourceNode().get());
				if (!isChildOfParent) {
					continue;
				}
			}

			break;
		}

		if (!methodDeclaration.isPresent()) {
			return result;
		}
		
		JavaClass javaClass = new JavaClass(context);
		javaClass.setClassDeclaration(methodDeclaration.get().findAncestor(ClassOrInterfaceDeclaration.class).get());

		JavaMethodDeclaration jmd = new JavaMethodDeclaration(context);
		jmd.setMethodDeclaration(methodDeclaration.get());
		jmd.setAncestorClass(javaClass);

		result = Optional.of(jmd);
		
		return result;
	}
	
	public Optional<Modifier> getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(Optional<Modifier> accessModifier) {
		this.accessModifier = accessModifier;
	}

	public Optional<Boolean> getStaticModifier() {
		return staticModifier;
	}

	public void setStaticModifier(Optional<Boolean> staticModifier) {
		this.staticModifier = staticModifier;
	}

	public Optional<Boolean> getAbstractModifier() {
		return abstractModifier;
	}

	public void setAbstractModifier(Optional<Boolean> abstractModifier) {
		this.abstractModifier = abstractModifier;
	}

	public Optional<Boolean> getFinalModifier() {
		return finalModifier;
	}

	public void setFinalModifier(Optional<Boolean> finalModifier) {
		this.finalModifier = finalModifier;
	}

	public Optional<Boolean> getNativeModifier() {
		return nativeModifier;
	}

	public void setNativeModifier(Optional<Boolean> nativeModifier) {
		this.nativeModifier = nativeModifier;
	}

	public Optional<Boolean> getSynchronizedModifier() {
		return synchronizedModifier;
	}

	public void setSynchronizedModifier(Optional<Boolean> synchronizedModifier) {
		this.synchronizedModifier = synchronizedModifier;
	}

	public Optional<String> getReturnType() {
		return returnType;
	}

	public void setReturnType(Optional<String> returnType) {
		this.returnType = returnType;
	}

	public Optional<String> getMethodName() {
		return methodName;
	}

	public void setMethodName(Optional<String> methodName) {
		this.methodName = methodName;
	}

	public Optional<List<String>> getParameterTypes() {
		return parameterTypes;
	}

	public void setParameterTypes(Optional<List<String>> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public Optional<List<String>> getThrowsTypes() {
		return throwsTypes;
	}

	public void setThrowsTypes(Optional<List<String>> throwsTypes) {
		this.throwsTypes = throwsTypes;
	}

	private Optional<Modifier> accessModifier = Optional.empty();
	private Optional<Boolean> staticModifier = Optional.empty();
	private Optional<Boolean> abstractModifier = Optional.empty();
	private Optional<Boolean> finalModifier = Optional.empty();
	private Optional<Boolean> nativeModifier = Optional.empty();
	private Optional<Boolean> synchronizedModifier = Optional.empty();
	private Optional<String> returnType = Optional.empty();
	private Optional<String> methodName = Optional.empty();	
	private Optional<List<String>> parameterTypes = Optional.empty();
	private Optional<List<String>> throwsTypes = Optional.empty();
	private Optional<Position> lastPosition = Optional.empty();
	
}
