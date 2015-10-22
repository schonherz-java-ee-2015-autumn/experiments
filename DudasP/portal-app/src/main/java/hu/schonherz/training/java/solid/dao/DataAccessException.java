package hu.schonherz.training.java.solid.dao;

public class DataAccessException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 5333260864465128647L;

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
