package mil.darpa.immortals.core.das.pql;

import java.util.Optional;

import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;

public class ContextValue {

	public ContextValue(ContextValueType contextValueType, String value) {
		this.contextValueType = contextValueType;
		switch (contextValueType) {
		case NameExpression:
		case NumericLiteral:
		case BooleanLiteral:
			this.value = value;
			break;
		case StringLiteral:
			this.value = "\"" + value + "\"";
			break;
		case NullLiteral:
			this.value = "null";
			break;
		case CodeArtifact:
			this.value = value;
			break;
		case CharLiteral:
			this.value = "'" + value + "'";
			break;
		default:
			throw new RuntimeException("Invalid use of array ContextValue.");
		}
	}

	public ContextValue(ContextValueType contextValueType, String[] value) {
		this.contextValueType = contextValueType;
		switch (contextValueType) {
		case NameExpression:
		case NumericLiteral:
		case BooleanLiteral:
		case StringLiteral:
		case NullLiteral:
		case CodeArtifact:
		case CharLiteral:
			throw new RuntimeException("Invalid use of array ContextValue.");
		case BooleanLiteralArray:
			this.valueArray = value;
			break;
		case NameExpressionArray:
			this.valueArray = value;
			break;
		case CharLiteralArray:
			this.valueArray = value;
			for (int x=0; x < value.length; x++) {
				this.valueArray[x] = "'" + value + "'";
			}
			break;
		case StringLiteralArray:
			this.valueArray = value;
			for (int x=0; x < value.length; x++) {
				this.valueArray[x] = "\"" + value[x] + "\"";
			}
			break;
		}
	}

	public ContextValue(ContextValueType contextValueType, char value) {
		this.contextValueType = contextValueType;
		this.value = "'" + value + "'";
	}
	
	public ContextValue(ContextValueType contextValueType, Number value) {
		this.contextValueType = contextValueType;
		this.value = String.valueOf(value);
	}

	public ContextValue(ContextValueType contextValueType, Boolean value) {
		this.contextValueType = contextValueType;
		this.value = String.valueOf(value);
	}
	
	public ContextValue(ContextValueType contextValueType, CodeArtifact codeArtifact) {
		this.contextValueType = contextValueType;
		value = codeArtifact.getSourceText();
		this.codeArtifact = Optional.of(codeArtifact);
	}

	public ContextValue(ContextValueType contextValueType) {
		this.contextValueType = contextValueType;
		value = "null";
	}

	public String getValue() {
		return value;
	}
	
	public ContextValueType getContextValueType() {
		return contextValueType;
	}
	
	public Optional<CodeArtifact> getCodeArtifact() {
		return codeArtifact;
	}
	
	public String[] getValueArray() {
		return valueArray;
	}

	private ContextValueType contextValueType;
	private String value;
	private Optional<CodeArtifact> codeArtifact;
	private String[] valueArray;
	
}
