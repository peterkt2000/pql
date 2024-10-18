package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.exceptions.UnimplementedMemberException;

public class FragmentPatternMatch extends AbstractCodeArtifact {

	public FragmentPatternMatch(PQLContext context) {
		super(context);
	}
	
	@Override
	public Position getStartPosition() {

		Position position = null;
		
		if (childCodeArtifacts.isPresent() && !childCodeArtifacts.get().isEmpty()) {
			position = childCodeArtifacts.get().get(0).getStartPosition();
		}
		
		return position;
	}

	@Override
	public Position getEndPosition() {
		
		Position position = null;
		
		if (childCodeArtifacts.isPresent() && !childCodeArtifacts.get().isEmpty()) {
			position = childCodeArtifacts.get().get(childCodeArtifacts.get().size()-1).getEndPosition();
		}
		
		return position;
	}

	@Override
	public String getSourceText() {
		
		StringBuilder sb = new StringBuilder();
		
		if (childCodeArtifacts.isPresent()) {
			for (CodeArtifact ca : childCodeArtifacts.get()) {
				sb.append(ca.getSourceText());
			}
		}
		
		return sb.toString();
	}

	@Override
	public JavaClass getAncestorClass() {
		return null;
	}	

	@Override
	public void setAncestorClass(JavaClass javaClass) {
		throw new UnimplementedMemberException();
	}

	@Override
	public Optional<Node> getSourceNode() {
		return null;
	}

}
