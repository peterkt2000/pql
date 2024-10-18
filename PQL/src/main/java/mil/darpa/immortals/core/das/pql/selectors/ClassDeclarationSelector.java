package mil.darpa.immortals.core.das.pql.selectors;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.exceptions.InvalidOrMissingParameters;

public class ClassDeclarationSelector extends AbstractSelector<JavaClass> {

	@Override
	public Optional<JavaClass> select(PQLContext context, Optional<Position> after,
			Optional<CodeArtifact> parentCodeArtifact) {

		if (context == null) {
			throw new InvalidOrMissingParameters("context");
		}

		Optional<JavaClass> classDeclaration = Optional.empty();

		Optional<ClassOrInterfaceDeclaration> classOrInterfaceDeclaration = Optional.empty();

		lastPosition = after;
		
		while (true) {
			classOrInterfaceDeclaration = context.getCompilationUnit().findFirst(ClassOrInterfaceDeclaration.class, 
						t -> (accessModifier.isPresent() ? (Modifier.isEqual(t.getAccessSpecifier(), accessModifier.get())) : true)
						&& (staticModifier.isPresent() ? (t.isStatic() == staticModifier.get()) : true)
						&& (finalModifier.isPresent() ? (t.isFinal() == finalModifier.get()) : true)
						&& (abstractModifier.isPresent() ? (t.isAbstract() == abstractModifier.get()) : true)
						&& (superClassType.isPresent() ? (isExtendingType(context, t, superClassType.get(), context.getTypeSolver())) : true)
						&& (interfaceTypes.isPresent() ? (isImplementingTypes(context, t, interfaceTypes.get(), context.getTypeSolver())) : true)
						&& (nestedClass.isPresent() ? (t.isNestedType() == nestedClass.get()) : true)
						&& t.getBegin().filter(p -> p.isAfter(lastPosition.orElse(Position.HOME))).isPresent());
			
			if (!classOrInterfaceDeclaration.isPresent()) {
				break;
			}
			
			lastPosition = classOrInterfaceDeclaration.get().getEnd();
			
			if (parentCodeArtifact.isPresent()) {
				boolean isChildOfParent = classOrInterfaceDeclaration.get().isDescendantOf(parentCodeArtifact.get().getSourceNode().get());
				if (!isChildOfParent) {
					continue;
				}
			}
			
			break;
		}
		
		if (!classOrInterfaceDeclaration.isPresent()) {
			return classDeclaration;
		}

		JavaClass javaClass = new JavaClass(context);
		javaClass.setClassDeclaration(classOrInterfaceDeclaration.get());

		classDeclaration = Optional.of(javaClass);
		
		return classDeclaration;
	}
	
	public Optional<String> getSuperClassType() {
		return superClassType;
	}

	public void setSuperClassType(Optional<String> superClassType) {
		this.superClassType = superClassType;
	}

	public Optional<List<String>> getInterfaceTypes() {
		return interfaceTypes;
	}

	public void setInterfaceTypes(Optional<List<String>> interfaceTypes) {
		this.interfaceTypes = interfaceTypes;
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

	public Optional<Boolean> getFinalModifier() {
		return finalModifier;
	}

	public void setFinalModifier(Optional<Boolean> finalModifier) {
		this.finalModifier = finalModifier;
	}

	public Optional<Boolean> getAbstractModifier() {
		return abstractModifier;
	}

	public void setAbstractModifier(Optional<Boolean> abstractModifier) {
		this.abstractModifier = abstractModifier;
	}

	public Optional<Boolean> getNestedClass() {
		return nestedClass;
	}

	public void setNestedClass(Optional<Boolean> nestedClass) {
		this.nestedClass = nestedClass;
	}

	private Optional<String> superClassType;
	private Optional<List<String>> interfaceTypes;
	private Optional<Modifier> accessModifier;
	private Optional<Boolean> staticModifier;
	private Optional<Boolean> finalModifier;
	private Optional<Boolean> abstractModifier;
	private Optional<Boolean> nestedClass;
	private Optional<Position> lastPosition;
	
}
