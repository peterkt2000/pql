package mil.darpa.immortals.core.das.pql.commands;

import java.util.List;

import mil.darpa.immortals.core.das.pql.PQLContext;

public class AddImports extends AbstractCommand {

	public AddImports(List<String> imports) {
		setImports(imports);
	}

	@Override
	public void execute(PQLContext context) throws Exception {
		
		imports.stream().forEach(i -> context.getCompilationUnit().addImport(i, false, false));
		
	}
	
	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}
	
	@Override
	public boolean isModifyingCommand() {
		return true;
	}

	private List<String> imports;
}
