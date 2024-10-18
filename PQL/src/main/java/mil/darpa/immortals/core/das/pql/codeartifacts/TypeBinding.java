package mil.darpa.immortals.core.das.pql.codeartifacts;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.type.Type;

public class TypeBinding {

	public TypeBinding() {}
	
	public TypeBinding(String typeName, String bindingName) {
		this.typeName = typeName;
		this.bindingName = bindingName;
	}
	
	public TypeBinding(String bindingName) {
		this.bindingName = bindingName;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public String getBindingName() {
		return bindingName;
	}

	public static Type getParsedType(String typeName) {
		
		//ForUpdate
		//Type result = JavaParser.parseType(typeName);
		Type result = StaticJavaParser.parseType(typeName);

		return result;
	}
	
	private String typeName;
	private String bindingName;
}
