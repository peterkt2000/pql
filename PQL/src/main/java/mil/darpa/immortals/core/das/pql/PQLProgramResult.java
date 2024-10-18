package mil.darpa.immortals.core.das.pql;

import org.antlr.v4.runtime.tree.ParseTree;

import mil.darpa.immortals.core.das.pql.generated.PQLParser;

public class PQLProgramResult {

	public PQLProgramResult(String pqlProgram, PQLParser parser, ParseTree parseTree) {
		this.pqlProgram = pqlProgram;
		this.parser = parser;
		this.parseTree = parseTree;
	}
	
	public String getPqlProgram() {
		return pqlProgram;
	}

	public void setPqlProgram(String pqlProgram) {
		this.pqlProgram = pqlProgram;
	}

	public PQLParser getParser() {
		return parser;
	}

	public void setParser(PQLParser parser) {
		this.parser = parser;
	}

	public ParseTree getParseTree() {
		return parseTree;
	}
	
	public void setParseTree(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
	
	private String pqlProgram;
	private PQLParser parser;
	private ParseTree parseTree;
}
