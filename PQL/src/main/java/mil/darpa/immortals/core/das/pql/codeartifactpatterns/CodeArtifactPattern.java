package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;

import mil.darpa.immortals.core.das.pql.DuplicatePolicy;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.SearchPolicy;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;

public interface CodeArtifactPattern<T extends CodeArtifact> {
	
	Optional<T> match(PQLContext context, Optional<Position> after, Optional<CodeArtifact> parentCodeArtifact);
	
	//Reset processed (to false) and clear matches; do this before searching a compilation unit
	void reset();
	
	//Did pattern have all information it needed to be processed
	boolean isProcessed();
		
	//Keep track of location in pattern hierarchy (parent pattern and child patterns)
	Optional<CodeArtifactPattern<? extends CodeArtifact>> getParentCodeArtifactPattern();
	void setParentCodeArtifactPattern(CodeArtifactPattern<? extends CodeArtifact> codeArtifactPattern);
	Optional<List<CodeArtifactPattern<? extends CodeArtifact>>> getChildCodeArtifactPatterns();
	void addChildCodeArtifactPattern(CodeArtifactPattern<? extends CodeArtifact> codeArtifactPattern);
	void setChildCodeArtifactPatterns(List<CodeArtifactPattern<? extends CodeArtifact>> codeArtifactPatterns);

	public SearchPolicy getFragmentSearchPolicy();
	public void setFragmentSearchPolicy(SearchPolicy fragmentSearchPolicy);
	public SearchPolicy getChildSearchPolicy();
	public void setChildSearchPolicy(SearchPolicy childSearchPolicy);
	public void setDuplicatePolicy(DuplicatePolicy duplicatePolicy);
	public DuplicatePolicy getDuplicatePolicy();

}
