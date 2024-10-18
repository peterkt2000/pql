package mil.darpa.immortals.core.das.pql;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import mil.darpa.immortals.core.das.pql.generated.PQLLexer;
import mil.darpa.immortals.core.das.pql.generated.PQLParser;

public class PQLProgramGenerator {

	public PQLProgramGenerator() {
	}
	
	public PQLProgramResult generatePQLProgram(String pqlSource, String pqlProgramClassName) throws Exception {
		
		if (pqlSource == null || pqlSource.trim().length() == 0) {
			throw new Exception("Missing pql source program.");
		}
		
        PQLLexer lexer = new PQLLexer(CharStreams.fromString(pqlSource));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PQLParser parser = new PQLParser(tokens);
        ParseTree tree = parser.prog();

        // create a standard ANTLR parse tree walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // create listener then feed to walker
        PQLListener pqlListener = new PQLListener();
        pqlListener.setPqlProgramClassName(pqlProgramClassName);
        walker.walk(pqlListener, tree); // walk parse tree

        return new PQLProgramResult(pqlListener.getProgram(), parser, tree);
	}
}
