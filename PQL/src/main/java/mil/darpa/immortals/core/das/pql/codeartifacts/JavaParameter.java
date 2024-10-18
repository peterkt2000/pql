package mil.darpa.immortals.core.das.pql.codeartifacts;

import mil.darpa.immortals.core.das.pql.PQLExpression;

public class JavaParameter {
	
	public JavaParameter(int position, boolean finalModifier, String type, PQLExpression name) {
		this.position = position;
		this.type = type;
		this.name = name;
		this.finalModifier = finalModifier;
	}

	public JavaParameter(boolean finalModifier, String type, PQLExpression name, int addAfterPosition) {
		this.addAfterPosition = addAfterPosition;
		this.type = type;
		this.name = name;
		this.finalModifier = finalModifier;
	}

	public int getPosition() {
		return position;
	}

	public PQLExpression getName() {
		return name;
	}

	public void setName(PQLExpression name) {
		this.name = name;
	}

	public boolean isFinalModifier() {
		return finalModifier;
	}
	
	public int getAddAfterPosition() {
		return addAfterPosition;
	}

	public void setAddAfterPosition(int addAfterPosition) {
		this.addAfterPosition = addAfterPosition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResolvedName() {
		return resolvedName;
	}

	public void setResolvedName(String resolvedName) {
		this.resolvedName = resolvedName;
	}

	private int position;
	private String type;
	private PQLExpression name;
	private String resolvedName;
	private boolean finalModifier;
	private int addAfterPosition;
	
}
