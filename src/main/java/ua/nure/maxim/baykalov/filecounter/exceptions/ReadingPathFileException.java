package ua.nure.maxim.baykalov.filecounter.exceptions;

public class ReadingPathFileException extends RuntimeException {
	
	/**
	 * The type of exception, that is thrown when the path file can't be read  
	 */
	private static final long serialVersionUID = -7661136666207830794L;

	public ReadingPathFileException() {
		super();
	}

	public ReadingPathFileException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReadingPathFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReadingPathFileException(String message) {
		super(message);
	}

	public ReadingPathFileException(Throwable cause) {
		super(cause);
	}
		
}
