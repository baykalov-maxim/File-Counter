package ua.nure.maxim.baykalov.filecounter.exceptions;

public class CreateOutputCSVFileException extends RuntimeException {

	/**
	 * The type of exception, that is thrown when user has not root or file is open
	 */
	private static final long serialVersionUID = -3355826015506053355L;

	public CreateOutputCSVFileException() {
		super();
	}

	public CreateOutputCSVFileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CreateOutputCSVFileException(String arg0) {
		super(arg0);
	}

	public CreateOutputCSVFileException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreateOutputCSVFileException(Throwable arg0) {
		super(arg0);
	}

}
