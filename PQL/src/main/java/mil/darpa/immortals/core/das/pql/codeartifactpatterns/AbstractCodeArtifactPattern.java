package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;

import mil.darpa.immortals.core.das.pql.DuplicatePolicy;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.SearchPolicy;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;

public abstract class AbstractCodeArtifactPattern<T extends CodeArtifact> implements CodeArtifactPattern<T> {

	@Override
	public abstract Optional<T> match(PQLContext context, Optional<Position> after, Optional<CodeArtifact> parentCodeArtifact);
	
	@Override
	public boolean isProcessed() {
		return processed;
	}
	
	/**
	 * Add a CodeArtifact match to this pattern.
	 * 
	 * Intended for use only by concrete pattern classes to keep track of previous matches for the purpose of avoiding duplicates.
	 * These matches are cleared for each root pattern iteration (or more frequently in some patterns like ClassDeclarationPattern).
	 * 
	 * @param codeArtifact a result of a pattern match
	 */
	protected void addMatch(CodeArtifact codeArtifact) {
		if (!matches.isPresent()) {
			matches = Optional.of(new ArrayList<CodeArtifact>());
		}
		
		matches.get().add(codeArtifact);
	}
	
	/**
	 * Check if matches contains the CodeArtifact (equals and hashCode are overridden in AbstractCodeArtifact).
	 * 
	 * Intended for use only by concrete pattern classes to keep track of previous matches for the purpose of avoiding duplicates.
	 * These matches are cleared for each root pattern iteration (or more frequently in some patterns like ClassDeclarationPattern).
	 * 
	 * @param codeArtifact
	 * @return
	 */
	protected boolean matchesContain(CodeArtifact codeArtifact) {
		
		boolean result = false;
		
		if (matches.isPresent()) {
			result = matches.get().contains(codeArtifact);
		}
		
		return result;
	}

	/**
	 * Returns optional list of matches.
	 * 
	 * Intended for use only by concrete pattern classes to keep track of previous matches for the purpose of avoiding duplicates.
	 * These matches are cleared for each root pattern iteration (or more frequently in some patterns like ClassDeclarationPattern).
	 * 
	 * @return
	 */
	protected Optional<List<CodeArtifact>> getMatches() {
		return matches;
	}

	@Override
	public Optional<CodeArtifactPattern<? extends CodeArtifact>> getParentCodeArtifactPattern() {
		return parentCodeArtifactPattern;
	}

	@Override
	public void setParentCodeArtifactPattern(CodeArtifactPattern<? extends CodeArtifact> codeArtifactPattern) {
		parentCodeArtifactPattern = Optional.of(codeArtifactPattern);
	}

	@Override
	public Optional<List<CodeArtifactPattern<? extends CodeArtifact>>> getChildCodeArtifactPatterns() {
		return childCodeArtifactPatterns;
	}

	@Override
	public void addChildCodeArtifactPattern(CodeArtifactPattern<? extends CodeArtifact> codeArtifactPattern) {
		if (!childCodeArtifactPatterns.isPresent()) {
			childCodeArtifactPatterns = Optional.of(new ArrayList<CodeArtifactPattern<? extends CodeArtifact>>());
		}
		childCodeArtifactPatterns.get().add(codeArtifactPattern);
	}

	@Override
	public void setChildCodeArtifactPatterns(List<CodeArtifactPattern<? extends CodeArtifact>> codeArtifactPatterns) {
		childCodeArtifactPatterns = Optional.of(codeArtifactPatterns);
	}
	
	@Override
	public void reset() {
		processed = false;
		this.matches.ifPresent(m -> m.clear());
		childCodeArtifactPatterns.ifPresent(patterns -> patterns.forEach(p -> p.reset()));
	}

	@Override
	public SearchPolicy getFragmentSearchPolicy() {
		return fragmentSearchPolicy;
	}

	@Override
	public void setFragmentSearchPolicy(SearchPolicy fragmentSearchPolicy) {
		this.fragmentSearchPolicy = fragmentSearchPolicy;
	}

	@Override
	public SearchPolicy getChildSearchPolicy() {
		return childSearchPolicy;
	}

	@Override
	public void setChildSearchPolicy(SearchPolicy childSearchPolicy) {
		this.childSearchPolicy = childSearchPolicy;
	}
	
	@Override
	public void setDuplicatePolicy(DuplicatePolicy duplicatePolicy) {
		this.duplicatePolicy = duplicatePolicy;
	}

	@Override
	public DuplicatePolicy getDuplicatePolicy() {
		return duplicatePolicy;
	}

	protected boolean processed = false;
	protected Optional<CodeArtifactPattern<? extends CodeArtifact>> parentCodeArtifactPattern = Optional.empty();
	protected Optional<List<CodeArtifactPattern<? extends CodeArtifact>>> childCodeArtifactPatterns = Optional.empty();
	
	/**
	 * Intended for use only by concrete pattern classes to keep track of previous matches for the purpose of avoiding duplicates.
	 */
	protected Optional<List<CodeArtifact>> matches = Optional.empty();

	protected SearchPolicy fragmentSearchPolicy;
	protected SearchPolicy childSearchPolicy;
	protected DuplicatePolicy duplicatePolicy;

}
