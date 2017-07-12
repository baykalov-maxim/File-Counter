package ua.nure.maxim.baykalov.filecounter.exceptions;

public class PathIsNotDirException extends RuntimeException {

	/**
	 * The type of exception, that is thrown when path is invalid or isn't directory
	 */
	private static final long serialVersionUID = -5733136465740150621L;

	public PathIsNotDirException() {
		super();
	}

	public PathIsNotDirException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PathIsNotDirException(String message, Throwable cause) {
		super(message, cause);
	}

	public PathIsNotDirException(String message) {
		super(message);
	}

	public PathIsNotDirException(Throwable cause) {
		super(cause);
	}
}
