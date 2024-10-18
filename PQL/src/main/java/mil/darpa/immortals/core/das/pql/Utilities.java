package mil.darpa.immortals.core.das.pql;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

public class Utilities {

	private Utilities() {}

	public static String processCode(String code, PQLContext context, RootFragmentPatternMatch rootFragmentPatternMatch) {
		
		//Prepare the replacement (process bindings and special commands)
		String replacementCode = code;
		Pattern newVariables = Pattern.compile("@\\$:newVariable:(\\w+)");
		Pattern bindings = Pattern.compile("@\\$(\\w+)");

		Matcher nvm = null;
		String variableName = null;
		String replacementPattern = null;
		nvm = newVariables.matcher(replacementCode);
		Set<String> replacedVariables = new HashSet<>();
		
		while (nvm.find()) {
			variableName = nvm.group(1);
			String collisionResistantName = context.createOrGetCollisionResistantName(variableName);
			if (!replacedVariables.contains(variableName)) {
				replacementPattern = "@\\$:newVariable:" + variableName;
				replacementCode = replacementCode.replaceAll(replacementPattern, collisionResistantName);
				replacedVariables.add(variableName);
			}
		}
		
		nvm = bindings.matcher(replacementCode);
		Set<String> replacedBindings = new HashSet<>();
		String bindingName = null;
		while (nvm.find()) {
			bindingName = nvm.group(1);
			if (!replacedBindings.contains(bindingName) && rootFragmentPatternMatch.containsBinding(bindingName)) {
				replacementPattern = "@\\$" + bindingName;
				replacementCode = replacementCode.replaceAll(replacementPattern, rootFragmentPatternMatch.getBinding(bindingName).getValue());
				replacedBindings.add(bindingName);
			}
		}
		
		return replacementCode;

	}
	
	public static boolean parseBoolean(String value) {
		
		boolean result = false;
		
		try {
			result = Boolean.valueOf(value);
		} catch (Exception e) {
			result = false;
		}
		
		return result;

	}
	
	public static List<Path> parsePaths(String rawPaths, String delimiter) {
		
		List<Path> result = new ArrayList<>();
		String[] paths = null;
		
		if (rawPaths != null && rawPaths.trim().length() > 0 && delimiter != null && delimiter.trim().length() == 1) { 
			paths = rawPaths.split(delimiter.trim());
			for(String path : paths) {
				result.add(Paths.get(path));
			}
		}
		
		return result;
	}
	
	public static Path getDirectoryPreservingTarget(Path configuredSourceRoot, Path configuredTarget, Path originalFile) {
		
		Path result = null;
		
		if (configuredSourceRoot != null && configuredTarget != null && originalFile != null && originalFile.startsWith(configuredSourceRoot)) {
			result = Paths.get(configuredTarget.toString(), originalFile.toString().substring(configuredSourceRoot.toString().length()));
		}
		
		return result;
	}
	
	public static String getNullableString(String value) {

		if (value != null) {
			return DQ + value + DQ;
		} else {
			return "null";
		}
	}
	
	public static String getNullableBoolean(String value) {
		
		if (value == null || !(value.trim().toLowerCase().equals("true") || value.trim().toLowerCase().equals("false"))) {
			return "null";
		} else {
			return value.trim().toLowerCase();
		}
	}
	
	public static String getNullableCodeSnippet(String value) {
		
		if (value == null) {
			return "null";
		} else {
			return value;
		}
	}
	
	public static boolean isBuiltInImport(String importPackage) {
		
		return importPackage.startsWith("java.lang");
	}
	
	public static String getUniqueName(String desiredName, Set<String> names) {
		
		if (desiredName == null || desiredName.length() == 0) {
			throw new RuntimeException("Invalid desiredName parameter in getUniqueName.");
		}
		
		String result = desiredName;
		
		int suffix = 2;
		
		if (names != null) {
			while (names.contains(result)) {
				result = desiredName.concat(String.valueOf(suffix++));
			}
		}
		
		return result;
	}
	
	public static String getTypeFromFullyQualifiedName(String fullyQualifiedTypeName) {
		
		String result = null;
		
		if (fullyQualifiedTypeName == null || fullyQualifiedTypeName.length() == 0) {
			throw new RuntimeException("Missing or empty fullyQualifiedTypeName in Utilities.getTypeFromFullyQualifiedName.");
		}
		
		int lastIndexOfPeriod = fullyQualifiedTypeName.lastIndexOf(".");
		
		if (lastIndexOfPeriod == -1) {
			result = fullyQualifiedTypeName;
		} else {
			result = fullyQualifiedTypeName.substring(lastIndexOfPeriod + 1);
		}
		
		return result;
	}
	
	public static String toCamelCase(String value) {
		
		String result = value;
		
		if (!(value == null || value.trim().length() == 0)) {
			result = value.substring(0, 1).toUpperCase().concat(value.substring(1));
		}
		
		return result;
	}
	
	private static final String DQ = "\"";

}
