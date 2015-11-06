package hu.schonherz.kepzes.java.common;

public class UserException extends Exception {

	public UserException() {

	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
}
