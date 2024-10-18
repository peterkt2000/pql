package mil.darpa.immortals.core.das.pql.selectors;

//ForUpdate
/*
import java.util.Optional;
import java.util.function.BiFunction;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.contexts.Declaration;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.ContextValueType;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifact.JavaDeclaration;
import mil.darpa.immortals.core.das.pql.codeartifact.TypeBinding;


public class ReferenceSelector extends AbstractSelector<JavaDeclaration> {

	@Override
	public Optional<JavaDeclaration> select(PQLContext context, Optional<Position> after) {

		Optional<JavaDeclaration> jd = Optional.empty();
		
        ContextValue cv = context.getBinding(this.getSeedBinding());
        
        if (cv == null || !cv.getContextValueType().equals(ContextValueType.CodeArtifact)) {
        	return jd;
        } else {
        	if (cv.getCodeArtifact() == null || !cv.getCodeArtifact().getSourceNode().isPresent()) {
        		return jd;
        	}
        }

    	Node seed = cv.getCodeArtifact().getSourceNode().get();

        BiFunction<Declaration, Node, Boolean> f = this::checkFunction;

        JavaParserFacade.get(context.getTypeSolver()).getSymbolSolver().solveLambda(seed, f);
		
        if (this.foundDeclaration != null) {
        	jd = Optional.of(new JavaDeclaration(context));

        	jd.get().setSymbol(this.foundDeclaration.getSymbol());
        	jd.get().setType(this.foundDeclaration.getType());
			context.addBinding(targetBinding.getBindingName(), 
					new ContextValue(ContextValueType.NameExpression, jd.get().getSymbol()));
        }
        
		return jd;
	}

    public Boolean checkFunction(Declaration d, Node node) {

        boolean result = false;

        if (d.getType().equals(this.referenceType)) {
        	this.foundDeclaration = d;
        	result = true;
        }
        
        return result;
    }
    
    public String getSeedBinding() {
		return seedBinding;
	}

	public void setSeedBinding(String seedBinding) {
		this.seedBinding = seedBinding;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public TypeBinding getTargetBinding() {
		return targetBinding;
	}

	public void setTargetBinding(TypeBinding targetBinding) {
		this.targetBinding = targetBinding;
	}


	private String seedBinding;
    private String referenceType;
    private Declaration foundDeclaration;
    private TypeBinding targetBinding;
}
*/
