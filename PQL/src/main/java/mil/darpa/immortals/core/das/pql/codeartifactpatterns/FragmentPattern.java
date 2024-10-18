package mil.darpa.immortals.core.das.pql.codeartifactpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.SearchPolicy;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.FragmentPatternMatch;

public class FragmentPattern extends AbstractCodeArtifactPattern<FragmentPatternMatch> {

	public FragmentPattern() {}
	
	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	@Override
	public Optional<FragmentPatternMatch> match(PQLContext context, Optional<Position> after,
			Optional<CodeArtifact> parentCodeArtifact) {

		Optional<FragmentPatternMatch> fragmentPatternMatch = Optional.empty();
		
		List<CodeArtifact> pendingMatches = new ArrayList<CodeArtifact>();
		
		boolean interruptedPattern = false;
		
		Optional<Position> codePatternRestartPosition = after;
		
		if (this.getChildCodeArtifactPatterns().isPresent()) {
			for (CodeArtifactPattern<? extends CodeArtifact> cap : this.getChildCodeArtifactPatterns().get()) {
				Optional<? extends CodeArtifact> ca = cap.match(context, codePatternRestartPosition, parentCodeArtifact);
				if (ca.isPresent()) {
					pendingMatches.add(ca.get());
					if (this.childSearchPolicy == SearchPolicy.RestartAtEndLastMatch) {
						codePatternRestartPosition = Optional.of(ca.get().getEndPosition());
					}
				} else {
					//No point continuing; we encountered a pattern we could not match
					interruptedPattern = true;
					pendingMatches.clear();
					break;
				}
			}
			
			if (!interruptedPattern) {
				fragmentPatternMatch = Optional.of(new FragmentPatternMatch(context));
				fragmentPatternMatch.get().addChildCodeArtifacts(pendingMatches);
				this.addMatch(fragmentPatternMatch.get());
			}
		}
		
		return fragmentPatternMatch;

	}

	private String binding;
	
}
