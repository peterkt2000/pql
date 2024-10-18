package mil.darpa.immortals.core.das.pql.exceptions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InvalidOrMissingParameters extends RuntimeException {

	private static final long serialVersionUID = 4439091867262329171L;

	public InvalidOrMissingParameters() {
		super(MESSAGE);
	}

	public InvalidOrMissingParameters(String ...params) {
		super(MESSAGE + Arrays.stream(params).collect(Collectors.joining(",")));
	}
	
	private static final String MESSAGE = "Invalid or missing parameters:";

}
