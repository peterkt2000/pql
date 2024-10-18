package mil.darpa.immortals.core.das.pql.codeartifacts;

import com.github.javaparser.ast.AccessSpecifier;

public enum Modifier {

    Private("private", "PRIVATE"),
    Public("public", "PUBLIC"),
    Protected("protected", "PROTECTED"),
    PackageLevel("", "PACKAGE_PRIVATE");

	private final String output;
	private final String name;

	Modifier(String output, String name) {
		this.output = output;
		this.name = name;
    }

	public String getName() {
		return name;
	}
	
	public String getOutput() {
		return output;
	}

	public static Modifier fromOutput(String output) {
    	
		Modifier result = null;
    	
        for (Modifier c: Modifier.values()) {
            if (c.output.equals(output)) {
                result = c;
            }
        }
        
        return result;
    }
	
	public static com.github.javaparser.ast.Modifier[] convertToJavaParserModifier(Modifier modifier, boolean isStatic,
			boolean isFinal) {
		
		int numberOfModifiers = 1;
		
		if (isStatic) {
			numberOfModifiers++;
		}
		
		if (isFinal) {
			numberOfModifiers++;
		}
		
		com.github.javaparser.ast.Modifier[] result = new com.github.javaparser.ast.Modifier[numberOfModifiers];
		
		//ForUpdate
		//Multiple changes
		switch (modifier) {
		case PackageLevel:
			//result[0] = com.github.javaparser.ast.Modifier.DEFAULT;
			result[0] =  new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.DEFAULT);
			break;
		case Private:
			//result[0] = com.github.javaparser.ast.Modifier.PRIVATE;
			result[0] =  new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.PRIVATE);
			break;
		case Protected:
			//result[0] = com.github.javaparser.ast.Modifier.PROTECTED;
			result[0] =  new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.PROTECTED);
			break;
		case Public:
			//result[0] = com.github.javaparser.ast.Modifier.PUBLIC;
			result[0] =  new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.PUBLIC);
			break;
		}
		
		if (isStatic) {
			//result[1] = com.github.javaparser.ast.Modifier.STATIC;
			result[1] = new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.STATIC);
		}

		if (isFinal) {
			result[2] = new com.github.javaparser.ast.Modifier(com.github.javaparser.ast.Modifier.Keyword.FINAL);
		}

		return result;
	}

	public static com.github.javaparser.ast.Modifier.Keyword[] convertToJavaParserModifierKeyword(Modifier modifier, boolean isStatic,
			boolean isFinal) {
		
		int numberOfModifiers = 1;
		
		if (isStatic) {
			numberOfModifiers++;
		}
		
		if (isFinal) {
			numberOfModifiers++;
		}
		
		com.github.javaparser.ast.Modifier.Keyword[] result = new com.github.javaparser.ast.Modifier.Keyword[numberOfModifiers];
		
		switch (modifier) {
		case PackageLevel:
			result[0] = com.github.javaparser.ast.Modifier.Keyword.DEFAULT;
			break;
		case Private:
			result[0] = com.github.javaparser.ast.Modifier.Keyword.PRIVATE;
			break;
		case Protected:
			result[0] = com.github.javaparser.ast.Modifier.Keyword.PROTECTED;
			break;
		case Public:
			result[0] = com.github.javaparser.ast.Modifier.Keyword.PUBLIC;
			break;
		}
		
		if (isStatic) {
			result[1] = com.github.javaparser.ast.Modifier.Keyword.STATIC;
		}
		
		if (isFinal) {
			result[2] = com.github.javaparser.ast.Modifier.Keyword.FINAL;
		}
		
		return result;
	}
		
	public static boolean isEqual(AccessSpecifier accessSpecifier, Modifier modifier) {
		
		boolean result = false;
		
		if (accessSpecifier != null && modifier != null) {
			result = accessSpecifier.name().equals(modifier.getName());
		}
		
		return result;
	}

}
