package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.github.javaparser.Position;
import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.DuplicatePolicy;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.SearchPolicy;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.selectors.ClassDeclarationSelector;

public class ClassDeclarationPattern extends AbstractCodeArtifactPattern<JavaClass> {

	public ClassDeclarationPattern(String id, Optional<String> superClassType, Optional<List<String>> interfaceTypes,
			Optional<Boolean> staticModifier, Optional<Boolean> finalModifier, Optional<Modifier> accessModifier,
			Optional<Boolean> abstractModifier, Optional<Boolean> nestedClass) {
		this.id = id;
		this.superClassType = superClassType;
		this.interfaceTypes = interfaceTypes;
		this.accessModifier = accessModifier;
		this.finalModifier = finalModifier;
		this.staticModifier = staticModifier;
		this.abstractModifier = abstractModifier;
		this.nestedClass = nestedClass;
	}
		
	public String getId() {
		return id;
	}

	@Override
	public Optional<JavaClass> match(PQLContext context, Optional<Position> after, 
			final Optional<CodeArtifact> parentCodeArtifact) {
		
		Optional<JavaClass> result = Optional.empty();
		
		ClassDeclarationSelector cds = new ClassDeclarationSelector();

		cds.setSuperClassType(superClassType);
		cds.setInterfaceTypes(interfaceTypes);
		cds.setFinalModifier(finalModifier);
		cds.setAccessModifier(accessModifier);
		cds.setStaticModifier(staticModifier);
		cds.setAbstractModifier(abstractModifier);
		cds.setNestedClass(nestedClass);

		Optional<JavaClass> jc = Optional.empty();
		
		switch (this.duplicatePolicy) {
			case HaltOnDuplicate:
				jc = cds.select(context, after, parentCodeArtifact);
				if (jc.isPresent() && this.matchesContain(jc.get())) {
					jc = Optional.empty();
				}
				break;
			case SearchNextUnique:
				if (this.getMatches().isPresent() && this.getMatches().get().size() > 0) {
					after = Optional.of(this.getMatches().get().get(this.getMatches().get().size()-1).getEndPosition());					
				}
				jc = cds.select(context, after, parentCodeArtifact);
				break;
			case AllowDuplicate:
				jc = cds.select(context, after, parentCodeArtifact);
				break;
			case CycleChildren:
				//Allow duplicates provided non-duplicate children are found;
				//when no non-duplicate children can be found, find next match for this pattern
				//We deal with this logic below during the child pattern matching
				if (!this.getChildCodeArtifactPatterns().isPresent() || this.getChildCodeArtifactPatterns().get().isEmpty()) {
					//No children; should behave like SearchNextUnique
					if (this.getMatches().isPresent() && this.getMatches().get().size() > 0) {
						after = Optional.of(this.getMatches().get().get(this.getMatches().get().size()-1).getEndPosition());					
					}
				}
				jc = cds.select(context, after, parentCodeArtifact);
				break;
			default:
				//Unsupported options for this pattern; should not occur if parser does its job
				throw new RuntimeException("Unsupported duplicate policy for code pattern: " + this.getClass().getName());
		}
		
		if (!jc.isPresent()) {
			return result;
		}

		List<CodeArtifact> pendingChildMatches = new ArrayList<CodeArtifact>();
		
		boolean failedMatch = false;
		boolean anotherParentToTry = false;
		
		Optional<Position> childPatternRestartPosition = Optional.empty();
		Optional<CodeArtifact> parent = Optional.empty();
		
		if (this.getChildCodeArtifactPatterns().isPresent() && !this.getChildCodeArtifactPatterns().get().isEmpty()) {
			while (jc.isPresent()) {
				//Set hierarchical parent of children and search start position
				parent = Optional.of(jc.get());
				childPatternRestartPosition = Optional.of(jc.get().getStartPosition());
				//Clear the children we've matched (this can happen if we cycle through for loop below and try the next parent)
				pendingChildMatches.clear();
				//These next two flags control our exit strategy
				anotherParentToTry = false;
				failedMatch = false;
				for (CodeArtifactPattern<? extends CodeArtifact> cap : this.getChildCodeArtifactPatterns().get()) {
					Optional<? extends CodeArtifact> ca = cap.match(context, childPatternRestartPosition, parent);
					if (ca.isPresent()) {
						pendingChildMatches.add(ca.get());
						if (this.childSearchPolicy == SearchPolicy.RestartAtEndLastMatch) {
							childPatternRestartPosition = Optional.of(ca.get().getEndPosition());
						}
					} else {
						if (this.getDuplicatePolicy() == DuplicatePolicy.CycleChildren) {
							//No more children under the current parent but restart policy indicates to try next
							//parent once we've cycled through all children.
							after = Optional.of(jc.get().getStartPosition());
							jc = cds.select(context, after, parentCodeArtifact);
							anotherParentToTry = true;
						} else {
							failedMatch = true;
						}
						break;
					}
				}
				if (failedMatch || !anotherParentToTry) {
					break;
				}
			}
		}

		if (!failedMatch && jc.isPresent()) {
			if (pendingChildMatches != null && !pendingChildMatches.isEmpty()) {
				jc.get().addChildCodeArtifacts(pendingChildMatches);
			}
			this.addMatch(jc.get());
			if (id != null) {
				context.getPendingBindings().put(id, 
						new ContextValue(ContextValueType.CodeArtifact, jc.get()));
			}
			result = jc;
		}

		this.processed = true;
		
		return result;
	}
	
	private String id;
	private Optional<String> superClassType;
	private Optional<List<String>> interfaceTypes;
	private Optional<Modifier> accessModifier;
	private Optional<Boolean> staticModifier;
	private Optional<Boolean> finalModifier;
	private Optional<Boolean> abstractModifier;
	private Optional<Boolean> nestedClass;
}
