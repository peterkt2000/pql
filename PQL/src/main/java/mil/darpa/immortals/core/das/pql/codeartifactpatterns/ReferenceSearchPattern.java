package mil.darpa.immortals.core.das.pql.codeartifactpatterns;
/*
import java.util.Optional;

import com.github.javaparser.Position;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifacts.TypeBinding;

import mil.darpa.immortals.core.das.pql.selector.ReferenceSelector;

public class ReferenceSearchPattern extends AbstractCodeArtifactPattern<JavaDeclaration> {

	public ReferenceSearchPattern(TypeBinding targetBinding, String seedBinding, String referenceType) {
		this.seedBinding = seedBinding;
		this.referenceType = referenceType;
		this.targetBinding = targetBinding;
	}
	
	@Override
	public Optional<JavaDeclaration> match(PQLContext context, Optional<Position> after) {
		
		Optional<JavaDeclaration> result = Optional.empty();
		if (context.getBinding(this.seedBinding) == null) {
			return result;
		}
		
		ReferenceSelector rs = new ReferenceSelector();
		
		rs.setSeedBinding(this.seedBinding);
		rs.setReferenceType(this.referenceType);
		rs.setTargetBinding(targetBinding);
		
		result = rs.select(context, after);
		
		this.processed = true;
		
		return result;
	}
	
	private String seedBinding;
	private String referenceType;
	private TypeBinding targetBinding;

}
*/
