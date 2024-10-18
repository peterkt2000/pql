package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.Statement;

import mil.darpa.immortals.core.das.pql.PatternContext;

public interface CodeArtifact {

	CompilationUnit getCompilationUnit();

	Position getStartPosition();
	Position getEndPosition();
	
	String getSourceText();
	Optional<Node> getSourceNode();
	
	Optional<PatternContext> getPatternContext();
	void setPatternContext(PatternContext patternContext);
	
	Optional<CodeArtifact> getParentCodeArtifact();
	void setParentCodeArtifact(CodeArtifact codeArtifact);
	
	Optional<List<CodeArtifact>> getChildCodeArtifacts();
	void setChildCodeArtifacts(List<CodeArtifact> codeArtifacts);
	void addChildCodeArtifact(CodeArtifact codeArtifact);
	void addChildCodeArtifacts(List<CodeArtifact> codeArtifacts);

	//These are questionable and maybe removed
	void setAncestorClass(JavaClass javaClass);
	JavaClass getAncestorClass();
	Optional<Statement> getContainingStatement();

}
