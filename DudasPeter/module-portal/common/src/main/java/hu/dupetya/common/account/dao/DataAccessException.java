package hu.dupetya.common.account.dao;

public class DataAccessException extends Exception {

	private static final long serialVersionUID = 3314752761248320400L;

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
