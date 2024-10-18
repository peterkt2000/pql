package mil.darpa.immortals.core.das.pql.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.github.javaparser.Position;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;

import mil.darpa.immortals.core.das.pql.ContextValue;
import mil.darpa.immortals.core.das.pql.PQLContext;
import mil.darpa.immortals.core.das.pql.Utilities;
import mil.darpa.immortals.core.das.pql.codeartifacts.CodeArtifact;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;

/**
 * This command needs to be tested. It works at the source file level (on a temporary file), which is not directly 
 * useful in the current PQL framework, which expects modifications to be applied to the CompilationUnit. 
 * 
 * Use ReplaceCodeStructured instead.
 * 
 * @see mil.darpa.immortals.core.das.pql.commands.ReplaceCodeStructured
 */
public class ReplaceCodeFileApproach extends AbstractCommand {

	public ReplaceCodeFileApproach(String id, String targetBinding, String replacement) {
		setId(id);
		setTargetBinding(targetBinding);
		setReplacement(replacement);
	}
	
	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		CodeArtifact ca = null;

		//Get the source file
		Path sourceFile = context.getCompilationUnit().getStorage().get().getPath();

		//Set up temporary file for making updates
		String tmpDir = System.getProperty("java.io.tmpdir");
		Path tmpSource = Paths.get(tmpDir, "PQL_TMP.java");
		Files.deleteIfExists(tmpSource);
	    tmpSource.toFile().deleteOnExit();
	    
	    //Copy source to temporary file
	    Files.copy(sourceFile, tmpSource);

		//Read all lines of code into list
	    List<String> codeLines = Files.readAllLines(sourceFile);

	    //Complete replacement in two passes (since otherwise your start/end positions would be invalidated by changes made to the source
	    //First, comment out to-be-replaced code and add markers for where new code is to be placed; be careful of multiple statements 
	    //that occur on one line of Java code (you must use line and character position values)

	    Position startReplacement = null;
		Position endReplacement = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent() && cv.getCodeArtifact().get().getSourceNode().isPresent()) {
				ca = cv.getCodeArtifact().get();
				
				startReplacement = ca.getStartPosition(); 
				endReplacement = ca.getEndPosition();

				//Shouldn't need next line enabled (since Lexical preservation is enabled during
				//initial parsing of the compilation unit.
				//LexicalPreservingPrinter.setup(ca.getSourceNode().get());
				String[] matchedLines = LexicalPreservingPrinter.print(ca.getSourceNode().get()).split(System.lineSeparator());

				//The codeLine list is 0-based, unlike javaparaser Positioning, which is 1-based
				String firstLine = codeLines.get(startReplacement.line-1);
				//Match can be anywhere on line; Java source may contain multiple statements on one line
				//Now it's up to PQL user to match on something that can be effectively commented out (usually a block level statement)
				//Matching on parts of a statement will create problems
				int startFirstLine = firstLine.indexOf(matchedLines[0]);
			    codeLines.set(startReplacement.line-1, firstLine.substring(0, startFirstLine) +  "//" + firstLine.substring(startFirstLine));
			    
				//Now comment out all intervening lines
			    for (int x = startReplacement.line; x < endReplacement.line-1; x++) {
		            codeLines.set(x, "//" + codeLines.get(x));
				}
				
			    //Now comment out match on last line (just like we did for first line)
				String lastLine = codeLines.get(endReplacement.line-1);
				int startLastLine = lastLine.indexOf(matchedLines[matchedLines.length-1]);
			    codeLines.set(endReplacement.line-1, lastLine.substring(0, startLastLine) +  "//" + lastLine.substring(startLastLine)
			    		+ INSERT_MARKER);
			}
		}

		int codeLineIndex = 0;
		
		String replacementCode = null;
		List<String> replacementLines = null;
		
		for (RootFragmentPatternMatch rfpm : context.getRootFragmentPatternMatches()) {
			ContextValue cv = rfpm.getBinding(this.getTargetBinding());
			if (cv.getCodeArtifact().isPresent()) {
				ca = cv.getCodeArtifact().get();
				
				replacementCode = Utilities.processCode(this.replacement, context, rfpm);
				
				replacementLines = Arrays.asList(replacementCode.split(System.lineSeparator()));
				
				for (; codeLineIndex < codeLines.size()-1; codeLineIndex++) {
					if (codeLines.get(codeLineIndex).endsWith(INSERT_MARKER)) {
						for (String s : replacementLines) {
							codeLines.add(++codeLineIndex, s);
						}
					}
				}
			}
		}
		
        String code = codeLines.stream().collect(Collectors.joining(System.lineSeparator()));

        Files.write(tmpSource, code.getBytes());	    	
		
	}

	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	private String replacement;
	private static final String INSERT_MARKER = "//[PQL_INSERT_MARKER]";

}
