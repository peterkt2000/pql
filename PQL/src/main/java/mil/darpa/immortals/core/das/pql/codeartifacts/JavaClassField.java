package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.FieldDeclaration;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpression;

public class JavaClassField extends AbstractCodeArtifact {

	public JavaClassField(PQLContext context) {
		super(context);
	}

	public JavaClassField(boolean idempotent, Modifier accessModifier, 
			boolean staticModifier, boolean finalModifier,
			String type, PQLExpression name, PQLExpression initializer) {
		this(null);
		setIdempotent(idempotent);
		setAccessModifier(accessModifier);
		setStaticModifier(staticModifier);
		setFinalModifier(finalModifier);
		setType(type);
		setFieldName(name);
		setInitializer(initializer);
	}

	public PQLExpression getFieldName() {
		return fieldName;
	}

	public void setFieldName(PQLExpression fieldName) {
		this.fieldName = fieldName;
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
		return javaClass;
	}

	@Override
	public void setAncestorClass(JavaClass javaClass) {
		this.javaClass = javaClass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PQLExpression getInitializer() {
		return initializer;
	}

	public void setInitializer(PQLExpression initializer) {
		this.initializer = initializer;
	}

	@Override
	public Optional<Node> getSourceNode() {
		return Optional.ofNullable(fieldDeclaration);
	}

	public FieldDeclaration getFieldDeclaration() {
		return fieldDeclaration;
	}

	public void setFieldDeclaration(FieldDeclaration fieldDeclaration) {
		this.fieldDeclaration = fieldDeclaration;
	}

	public Modifier getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(Modifier accessModifier) {
		this.accessModifier = accessModifier;
	}

	public boolean isIdempotent() {
		return idempotent;
	}

	public void setIdempotent(boolean idempotent) {
		this.idempotent = idempotent;
	}

	public boolean isStaticModifier() {
		return staticModifier;
	}

	public void setStaticModifier(boolean staticModifier) {
		this.staticModifier = staticModifier;
	}

	public boolean isFinalModifier() {
		return finalModifier;
	}

	public void setFinalModifier(boolean finalModifier) {
		this.finalModifier = finalModifier;
	}
	
	public String getResolvedFieldName() {
		return resolvedFieldName;
	}

	public void setResolvedFieldName(String resolvedFieldName) {
		this.resolvedFieldName = resolvedFieldName;
	}

	private Modifier accessModifier;
	private boolean staticModifier;
	private boolean finalModifier;
	private PQLExpression fieldName;
	private String resolvedFieldName;
	private JavaClass javaClass;
	private boolean idempotent;
	private String type;
	private PQLExpression initializer;
	private FieldDeclaration fieldDeclaration;

}
