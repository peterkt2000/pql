package mil.darpa.immortals.core.das.pql.selectors;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.LambdaExpr;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.JavaClass;
import mil.darpa.immortals.core.das.pql.codeartifacts.LambdaExpression;
import mil.darpa.immortals.core.das.pql.exceptions.InvalidOrMissingParameters;

public class LambdaExpressionSelector extends AbstractSelector<LambdaExpression> {

	@Override
	public Optional<LambdaExpression> select(PQLContext context, Optional<Position> after, Optional<CodeArtifact> parentCodeArtifact) {
		
		if (context == null) {
			throw new InvalidOrMissingParameters("context");
		}

		Optional<LambdaExpression> result = Optional.empty();

		Optional<LambdaExpr> lambdaExpression = Optional.empty();

		lastPosition = after;
		
		while (true) {
			lambdaExpression = context.getCompilationUnit().findFirst(LambdaExpr.class, 
					t -> t.getBegin().filter(p -> p.isAfter(lastPosition.orElse(Position.HOME))).isPresent());
	
			if (!lambdaExpression.isPresent()) {
				break;
			}
			
			lastPosition = lambdaExpression.get().getEnd();
			
			if (parentCodeArtifact.isPresent()) {
				boolean isChildOfParent = lambdaExpression.get().isDescendantOf(parentCodeArtifact.get().getSourceNode().get());
				if (!isChildOfParent) {
					continue;
				}
			}

			break;
		}

		if (!lambdaExpression.isPresent()) {
			return result;
		}
		
		JavaClass javaClass = new JavaClass(context);
		javaClass.setClassDeclaration(lambdaExpression.get().findAncestor(ClassOrInterfaceDeclaration.class).get());

		LambdaExpression le = new LambdaExpression(context);
		le.setLambdaExpression(lambdaExpression.get());
		le.setAncestorClass(javaClass);

		result = Optional.of(le);
		
		return result;

	}

	private Optional<Position> lastPosition = Optional.empty();
}
