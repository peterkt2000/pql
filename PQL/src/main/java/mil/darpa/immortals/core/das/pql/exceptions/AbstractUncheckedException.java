package mil.darpa.immortals.core.das.pql.exceptions;

public abstract class AbstractUncheckedException extends RuntimeException {

	private static final long serialVersionUID = -3733846117494550316L;

	public AbstractUncheckedException() {
	}

	public AbstractUncheckedException(String message) {
		super(message);
	}

	public AbstractUncheckedException(Throwable cause) {
		super(cause);
	}

	public AbstractUncheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractUncheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
