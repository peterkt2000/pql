package mil.darpa.immortals.core.das.pql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.SourceRoot;

import mil.darpa.immortals.core.das.pql.codeartifactpatterns.FragmentPattern;
import mil.darpa.immortals.core.das.pql.codeartifacts.FragmentPatternMatch;
import mil.darpa.immortals.core.das.pql.codeartifacts.RootFragmentPatternMatch;
import mil.darpa.immortals.core.das.pql.commands.Command;

public class PQLEngine {

	public PQLEngine(Path sourceToExamine, Path targetForModifications, List<Path> sourceCodeTypeSolverPaths, List<Path> jarTypeSolverPaths) throws IOException {
		
		this.sourceToExamine = sourceToExamine;
		this.targetForModifications = targetForModifications;
		
		typeSolver = new CombinedTypeSolver(new ReflectionTypeSolver());
		
		for (Path sc : sourceCodeTypeSolverPaths) {
			typeSolver.add(new JavaParserTypeSolver(sc.toFile()));
		}
		
		for (Path jar : jarTypeSolverPaths) {
			typeSolver.add(new JarTypeSolver(jar.toString()));
		}
		
		ParserConfiguration parserConfiguration =
				new ParserConfiguration().setSymbolResolver(new JavaSymbolSolver(typeSolver));
		parserConfiguration.setLexicalPreservationEnabled(true);

		SourceRoot searchRoot = new SourceRoot(sourceToExamine);
		searchRoot.setParserConfiguration(parserConfiguration);
		List<ParseResult<CompilationUnit>> parseResults = searchRoot.tryToParseParallelized("");

		compilationUnits = parseResults.stream()
				.filter(ParseResult::isSuccessful)
				.map(r -> r.getResult().get()).collect(Collectors.toList());
	}
		
	public PQLExecutionResult process() throws Exception {
		
		PQLExecutionResult pqlExecutionResult = new PQLExecutionResult();
		PQLContext context = new PQLContext();
		context.setTypeSolver(typeSolver);
		context.setPqlExecutionResult(pqlExecutionResult);
				
		FragmentPattern rootFragmentPattern = getRootFragmentPattern();
		
		for (CompilationUnit cu : compilationUnits) {
			//Since each pattern keeps track of its matches, we need to reset the patterns for each compilation unit
			rootFragmentPattern.reset();
			//The context keeps track of root fragment pattern matches (a root fragment pattern match occurs when all conditions
			//for the root pattern are satisfied; we need to reset these root fragment matches at the start of each compilation unit)
			//A compilation unit may have multiple root fragment pattern matches.
			context.reset();
			context.setCompilationUnit(cu);
			Path originalFile = cu.getStorage().get().getPath();
			pqlExecutionResult.addExaminedFile(originalFile);
			
			Optional<FragmentPatternMatch> fragmentPatternMatch = Optional.empty();
			Optional<Position> fragmentPatternRestartPosition = Optional.empty();
			do {
				context.resetPendingBindings();
				fragmentPatternMatch = rootFragmentPattern.match(context, fragmentPatternRestartPosition, Optional.empty());
				if (fragmentPatternMatch.isPresent()) {
					RootFragmentPatternMatch rfpm = new RootFragmentPatternMatch(fragmentPatternMatch.get());
					rfpm.setBindings(context.getPendingBindings());
					context.addRootFragmentPatternMatch(rfpm);
					if (rootFragmentPattern.getFragmentSearchPolicy() == SearchPolicy.RestartAtEndLastMatch) {
						fragmentPatternRestartPosition = Optional.of(fragmentPatternMatch.get().getEndPosition());
					}
					pqlExecutionResult.addMatchedFile(originalFile);
				}
			} while (fragmentPatternMatch.isPresent());
			
			boolean processedModifyingCommand = false;
			
			if (context.getRootFragmentPatternMatches().size() > 0) {
				try {
					for (Command c: commands) {
						c.execute(context);
						if (c.isModifyingCommand() && !processedModifyingCommand) {
							processedModifyingCommand = true;
						}
					}
					
					if (processedModifyingCommand) {
						Path targetLocation = Utilities.getDirectoryPreservingTarget(this.sourceToExamine, this.targetForModifications, originalFile);
						saveCompilationUnitToFile(cu, targetLocation);
						pqlExecutionResult.addModifiedFile(originalFile, targetLocation);
					}
				} catch (Exception e) {
					context.getPqlExecutionResult().addMessage(String.format("Unexpected error processing changes to file: %s: Message: %s", 
							context.getCompilationUnitFileName(), e.getMessage()));
				}
			}
		}
		
		return pqlExecutionResult;
	}
	
	private void saveCompilationUnitToFile(CompilationUnit cu, Path targetLocation) throws IOException {

		if (cu != null) {
			targetLocation.toFile().getParentFile().mkdirs();
			Files.write(targetLocation, LexicalPreservingPrinter.print(cu).getBytes());
		}
	}
		
	public FragmentPattern getRootFragmentPattern() {
		return rootFragmentPattern;
	}

	public void setRootFragmentPattern(FragmentPattern rootFragmentPattern) {
		this.rootFragmentPattern = rootFragmentPattern;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
	
	public CombinedTypeSolver getTypeSolver() {
		return typeSolver;
	}
	
	public Path getTargetForModifications() {
		return targetForModifications;
	}

	public Path getSourceToExamine() {
		return sourceToExamine;
	}

	private List<CompilationUnit> compilationUnits;
	private CombinedTypeSolver typeSolver;
	private FragmentPattern rootFragmentPattern;
	private List<Command> commands = new ArrayList<Command>();
	private Path targetForModifications;
	private Path sourceToExamine;
}
