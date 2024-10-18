package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.Optional;
import com.github.javaparser.Position;
import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PatternContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.LambdaExpression;
import mil.darpa.immortals.core.das.pql.selectors.LambdaExpressionSelector;

public class LambdaExpressionPattern extends AbstractCodeArtifactPattern<LambdaExpression> {

	public LambdaExpressionPattern(String id, Optional<PatternContext> patternContext) {
		this.id = id;
		this.patternContext = patternContext;
	}
		
	public String getId() {
		return id;
	}

	@Override
	public Optional<LambdaExpression> match(PQLContext context, Optional<Position> after, 
			final Optional<CodeArtifact> parentCodeArtifact) {
		
		Optional<LambdaExpression> result = Optional.empty();
		
		LambdaExpressionSelector les = new LambdaExpressionSelector();
		les.setPatternContext(this.patternContext);

		Optional<LambdaExpression> le = Optional.empty();

		switch (this.duplicatePolicy) {
			case HaltOnDuplicate:
				le = les.select(context, after, parentCodeArtifact);
				if (le.isPresent() && this.matchesContain(le.get())) {
					le = Optional.empty();
				}
				break;
			case SearchNextUnique:
				if (this.getMatches().isPresent() && this.getMatches().get().size() > 0) {
					after = Optional.of(this.getMatches().get().get(this.getMatches().get().size()-1).getEndPosition());					
				}
				le = les.select(context, after, parentCodeArtifact);
				break;
			case AllowDuplicate:
				le = les.select(context, after, parentCodeArtifact);
				break;
			case CycleChildren:
			default:
				//Unsupported options for this pattern; should not occur if parser does its job
				throw new RuntimeException("Unsupported duplicate policy for code pattern: " + this.getClass().getName());
		}

		if (!le.isPresent()) {
			return result;
		}

		//At this point we have a result that satisfies the duplicate policy

		//Add this match to the prior matches list
		this.addMatch(le.get());

		//Bind the match to its id so it can be used
		if (id != null) {
			context.getPendingBindings().put(id, 
				new ContextValue(ContextValueType.CodeArtifact, le.get()));
		}

		result = le;

		this.processed = true;

		return result;

	}

	public Optional<PatternContext> getPatternContext() {
		return patternContext;
	}

	private String id;
	private Optional<PatternContext> patternContext;

}
