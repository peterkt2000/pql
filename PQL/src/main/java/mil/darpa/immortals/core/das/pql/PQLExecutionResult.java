package mil.darpa.immortals.core.das.pql;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PQLExecutionResult {

	public PQLExecutionResult() {}
	
	public void addExaminedFile(Path examinedFile) {
		this.examinedFiles.add(examinedFile);
	}
	
	public Set<Path> getExaminedFiles() {
		return examinedFiles;
	}
	
	public void addFileOutput(Path file, String output) {
		fileOutput.put(file, output);
	}
	
	public String getFileOutput(Path file) {
		return fileOutput.get(file);
	}
	
	public void addModifiedFile(Path source, Path target) {
		modifiedFiles.put(source, target);
	}
	
	public Map<Path, Path> getModifiedFiles() {
		return modifiedFiles;
	}

	public Set<Path> getMatchedFiles() {
		return matchedFiles;
	}
	
	public void addMatchedFile(Path file) {
		matchedFiles.add(file);
	}
	
	public Map<Path, String> getFileOutput() {
		return fileOutput;
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	private Set<Path> examinedFiles = new HashSet<>();
	private Set<Path> matchedFiles = new HashSet<>();
	private Map<Path, Path> modifiedFiles = new HashMap<>();
	private Map<Path, String> fileOutput = new HashMap<>();
	private List<String> messages = new ArrayList<>();

}
