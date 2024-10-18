package mil.darpa.immortals.core.das.pql.selectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedFieldDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;

public class ReverseSymbolSolver {
	
	/**
	 * Finds nearest parent class declaration and finds all fields in scope.
	 * 
	 * @param seed Node representing the starting node
	 * @param typeSolver CombinedTypeSolver
	 * @param type String representing variable type to look for
	 * @return Set of nodes
	 */
	public LinkedHashMap<String, Node> getSymbolForTypeInClassDeclaration(Node seed, CombinedTypeSolver typeSolver, String type) {
		// Preserves order
		LinkedHashMap<String, Node> nodesToReturn = new LinkedHashMap<String, Node>();
		Set<String> namesOfNodes = new HashSet<String>();
		
        // Find nearest ancestor for seed of type ClassOrInterfaceDeclaration
		Optional<ClassOrInterfaceDeclaration> node = seed.findAncestor(ClassOrInterfaceDeclaration.class);
		
		boolean childWasStatic = false;
		while(node.isPresent()) {
			List<ResolvedFieldDeclaration> fields = new ArrayList<>();
			
			// Get all declared fields in node
	        fields.addAll(node.get().resolve().getDeclaredFields());
	       
	        
	        // Get all fields visible via extended or implemented types
	        node.get().getExtendedTypes().forEach(i -> fields.addAll(i.resolve().getAllFieldsVisibleToInheritors()));
	        node.get().getImplementedTypes().forEach(i -> fields.addAll(i.resolve().getAllFieldsVisibleToInheritors()));
	        
	        // Loop through all field declarations and determine if type satisfies filter,
	        // if so add to nodesToReturn
	        for(ResolvedFieldDeclaration i : fields) {
				if(i.getType().describe().contentEquals(type)){
					if(!namesOfNodes.contains(i.getName())) {
						// if class child was static, then the 
						// parent field must also be static for it to have scope
						if(!childWasStatic || (childWasStatic && i.isStatic())) {
							namesOfNodes.add(i.getName());
						
							// toAst returns the node associated with Field declaration
							nodesToReturn.put(i.getName(), i.toAst().get());
						}
					}
				}
			}

	        // Find nearest ancestor for node of type ClassOrInterfaceDeclaration
	        if(node.get().isStatic()) {
	        	childWasStatic = true;
	        }else {
	        	childWasStatic = false;
	        }
	        
	        node = node.get().findAncestor(ClassOrInterfaceDeclaration.class);
			
		}
		

		return nodesToReturn;
	}
	
}
