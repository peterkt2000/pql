package mil.darpa.immortals.core.das.pql.exceptions;

public class UnimplementedMemberException extends RuntimeException {

	private static final long serialVersionUID = 201204681574550482L;

	public UnimplementedMemberException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "Class does not implement the referenced member.";

}
