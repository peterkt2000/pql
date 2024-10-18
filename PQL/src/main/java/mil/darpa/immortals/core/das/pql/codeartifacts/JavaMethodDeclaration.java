package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import mil.darpa.immortals.core.das.pql.PQLContext;

public class JavaMethodDeclaration extends AbstractCodeArtifact {

	public JavaMethodDeclaration(PQLContext context) {
		super(context);
	}

	@Override
	public Position getStartPosition() {
		return methodDeclaration.getBegin().get();
	}

	@Override
	public Position getEndPosition() {
		return methodDeclaration.getEnd().get();
	}

	@Override
	public String getSourceText() {

		String result = "";
		
		if (getSourceNode().isPresent()) {
			result = getSourceNode().get().toString();
		}
		
		return result;

	}
	
	public MethodDeclaration getMethodDeclaration() {
		return methodDeclaration;
	}

	public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
		this.methodDeclaration = methodDeclaration;
	}

	@Override
	public JavaClass getAncestorClass() {
		return this.javaClass;
	}

	@Override
	public void setAncestorClass(JavaClass javaClass) {
		this.javaClass = javaClass;
	}

	@Override
	public Optional<Node> getSourceNode() {
		return Optional.ofNullable(methodDeclaration);
	}

	private MethodDeclaration methodDeclaration;
	private JavaClass javaClass;
	
}
