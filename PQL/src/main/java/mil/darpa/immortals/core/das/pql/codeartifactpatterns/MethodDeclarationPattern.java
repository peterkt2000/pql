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
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaMethodDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifacts.Modifier;
import mil.darpa.immortals.core.das.pql.selectors.MethodDeclarationSelector;

public class MethodDeclarationPattern extends AbstractCodeArtifactPattern<JavaMethodDeclaration> {

	public MethodDeclarationPattern(String id, 
			Optional<Modifier> accessModifier, Optional<Boolean> staticModifier,
			Optional<Boolean> abstractModifier, Optional<Boolean> finalModifier,
			Optional<Boolean> nativeModifier, Optional<Boolean> synchronizedModifier,
			Optional<String> returnType, Optional<String> methodName,
			Optional<List<String>> parameterTypes, Optional<List<String>> throwsTypes) {
		this.id = id;
		this.accessModifier = accessModifier;
		this.staticModifier = staticModifier;
		this.abstractModifier = abstractModifier;
		this.finalModifier = finalModifier;
		this.nativeModifier = nativeModifier;
		this.synchronizedModifier = synchronizedModifier;
		this.returnType = returnType;
		this.methodName = methodName;
		this.parameterTypes = parameterTypes;
		this.throwsTypes = throwsTypes;
	}
		
	public String getId() {
		return id;
	}

	@Override
	public Optional<JavaMethodDeclaration> match(PQLContext context, Optional<Position> after, 
			final Optional<CodeArtifact> parentCodeArtifact) {
		
		Optional<JavaMethodDeclaration> result = Optional.empty();
		
		MethodDeclarationSelector mds = new MethodDeclarationSelector();

		mds.setAccessModifier(accessModifier);
		mds.setStaticModifier(staticModifier);
		mds.setAbstractModifier(abstractModifier);
		mds.setFinalModifier(finalModifier);
		mds.setNativeModifier(nativeModifier);
		mds.setSynchronizedModifier(synchronizedModifier);
		mds.setReturnType(returnType);
		mds.setMethodName(methodName);		
		mds.setParameterTypes(parameterTypes);
		mds.setThrowsTypes(throwsTypes);

		Optional<JavaMethodDeclaration> jmd = Optional.empty();
		
		switch (this.duplicatePolicy) {
			case HaltOnDuplicate:
				jmd = mds.select(context, after, parentCodeArtifact);
				if (jmd.isPresent() && this.matchesContain(jmd.get())) {
					jmd = Optional.empty();
				}
				break;
			case SearchNextUnique:
				if (this.getMatches().isPresent() && this.getMatches().get().size() > 0) {
					after = Optional.of(this.getMatches().get().get(this.getMatches().get().size()-1).getEndPosition());					
				}
				jmd = mds.select(context, after, parentCodeArtifact);
				break;
			case AllowDuplicate:
				jmd = mds.select(context, after, parentCodeArtifact);
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
				jmd = mds.select(context, after, parentCodeArtifact);
				break;
			default:
				//Unsupported options for this pattern; should not occur if parser does its job
				throw new RuntimeException("Unsupported duplicate policy for code pattern: " + this.getClass().getName());
		}
		
		if (!jmd.isPresent()) {
			return result;
		}
		
		List<CodeArtifact> pendingChildMatches = new ArrayList<CodeArtifact>();
		
		boolean failedMatch = false;
		boolean anotherParentToTry = false;
		
		Optional<Position> childPatternRestartPosition = Optional.empty();
		Optional<CodeArtifact> parent = Optional.empty();
		
		if (this.getChildCodeArtifactPatterns().isPresent() && !this.getChildCodeArtifactPatterns().get().isEmpty()) {
			while (jmd.isPresent()) {
				//Set hierarchical parent of children and search start position
				parent = Optional.of(jmd.get());
				childPatternRestartPosition = Optional.of(jmd.get().getStartPosition());
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
							after = Optional.of(jmd.get().getEndPosition());
							jmd = mds.select(context, after, parentCodeArtifact);
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

		if (!failedMatch && jmd.isPresent()) {
			if (pendingChildMatches != null && !pendingChildMatches.isEmpty()) {
				jmd.get().addChildCodeArtifacts(pendingChildMatches);
			}
			this.addMatch(jmd.get());
			if (id != null) {
				context.getPendingBindings().put(id, 
						new ContextValue(ContextValueType.CodeArtifact, jmd.get()));
			}
			result = jmd;
		}

		this.processed = true;
		
		return result;
	}
	
	private String id;
	private Optional<Modifier> accessModifier;
	private Optional<Boolean> staticModifier;
	private Optional<Boolean> abstractModifier;
	private Optional<Boolean> finalModifier;
	private Optional<Boolean> nativeModifier;
	private Optional<Boolean> synchronizedModifier;
	private Optional<String> returnType;
	private Optional<String> methodName;	
	private Optional<List<String>> parameterTypes;
	private Optional<List<String>> throwsTypes;

}
