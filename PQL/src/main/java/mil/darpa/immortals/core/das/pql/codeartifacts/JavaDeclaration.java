package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;

import mil.darpa.immortals.core.das.pql.PQLContext;

public class JavaDeclaration extends AbstractCodeArtifact {

	public JavaDeclaration(PQLContext context) {
		super(context);
	}

	@Override
	public Position getStartPosition() {
		return null;
	}

	@Override
	public Position getEndPosition() {
		return null;
	}

	@Override
	public String getSourceText() {
		return null;
	}

	@Override
	public JavaClass getAncestorClass() {
		return null;
	}

	@Override
	public void setAncestorClass(JavaClass javaClass) {
	}

	@Override
	public Optional<Node> getSourceNode() {
		return null;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String symbol = null;
	private String type = null;
}
