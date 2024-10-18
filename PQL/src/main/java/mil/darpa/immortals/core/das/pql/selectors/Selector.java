package mil.darpa.immortals.core.das.pql.selectors;

import java.util.Optional;

import com.github.javaparser.Position;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;

public interface Selector<T extends CodeArtifact> {
	
	Optional<T> select(PQLContext context, Optional<Position> after, Optional<CodeArtifact> parentCodeArtifact);
	
	void setPatternContext(Optional<PatternContext> patternContext);
	Optional<PatternContext> getPatternContext();
	
}
