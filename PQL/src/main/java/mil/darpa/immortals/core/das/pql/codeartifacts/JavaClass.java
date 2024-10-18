package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.github.javaparser.Position;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.resolution.declarations.ResolvedFieldDeclaration;

import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.PQLExpressionType;
import mil.darpa.immortals.core.das.pql.Utilities;

public class JavaClass extends AbstractCodeArtifact {

	public JavaClass(PQLContext context) {
		super(context);
	}

	public boolean addImport(String packageName, PQLContext context) {
		
		boolean result = false;
		
		getCompilationUnit().addImport(packageName, false, false);
		
		return result;
	}
		
	public void addField(JavaClassField field, PQLContext context) {

		com.github.javaparser.ast.Modifier.Keyword[] modifiers = 
				Modifier.convertToJavaParserModifierKeyword(field.getAccessModifier(), field.isStaticModifier(), field.isFinalModifier());
		
		List<ResolvedFieldDeclaration> fields = classDeclaration.resolve().getDeclaredFields();
		Set<String> names = new HashSet<>();
		fields.forEach(f -> names.add(f.getName()));
		
		String uniqueFieldName = null;
		String desiredFieldName = null;
		
		if (field.getFieldName().getPQLExpressionType() == PQLExpressionType.Expression) {
			desiredFieldName = field.getFieldName().getExpression();
		} else if (field.getFieldName().getPQLExpressionType() == PQLExpressionType.ContextReference) {
			desiredFieldName = field.getFieldName().getBindingEvaluator().evaluate(context);
		}

		//Make desired field name unique (if necessary)
		uniqueFieldName = Utilities.getUniqueName(desiredFieldName, names);

		field.setResolvedFieldName(uniqueFieldName);
		
		boolean nameInUse = names.contains(desiredFieldName);
		
		if (!(nameInUse && field.isIdempotent())) {
			if (!Utilities.isBuiltInImport(field.getType())) {
				context.getCompilationUnit().addImport(field.getType(), false, false);
			}
			
			Expression expr = null;
			
			if (field.getInitializer().getPQLExpressionType() == PQLExpressionType.Expression) {
				expr = StaticJavaParser.parseExpression(field.getInitializer().getExpression());
			} else if (field.getInitializer().getPQLExpressionType() == PQLExpressionType.ContextReference) {
				expr = StaticJavaParser.parseExpression(field.getInitializer().getBindingEvaluator().evaluate(context)); 
			}
			
			FieldDeclaration fd = classDeclaration.addFieldWithInitializer(Utilities.getTypeFromFullyQualifiedName(field.getType()), 
					uniqueFieldName, expr, modifiers);
			field.setFieldDeclaration(fd);
		}
	}
	
	public void addMethod(String method, PQLContext context, RootFragmentPatternMatch rootFragmentPatternMatch) {
		
		String newMethod = Utilities.processCode(method, context, rootFragmentPatternMatch);
		BodyDeclaration<?> bd = StaticJavaParser.parseBodyDeclaration(newMethod);
		this.getClassDeclaration().addMember(bd);
	}

	@Override
	public Position getStartPosition() {
		return classDeclaration.getBegin().get();
	}

	@Override
	public Position getEndPosition() {
		return classDeclaration.getEnd().get();
	}

	@Override
	public String getSourceText() {

		String result = "";
		
		if (getSourceNode().isPresent()) {
			result = getSourceNode().get().toString();
		}
		
		return result;

	}
	
	public ClassOrInterfaceDeclaration getClassDeclaration() {
		return classDeclaration;
	}

	public void setClassDeclaration(ClassOrInterfaceDeclaration classDeclaration) {
		this.classDeclaration = classDeclaration;
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
		return Optional.ofNullable(classDeclaration);
	}

	private ClassOrInterfaceDeclaration classDeclaration;
	private JavaClass javaClass;
	
}
