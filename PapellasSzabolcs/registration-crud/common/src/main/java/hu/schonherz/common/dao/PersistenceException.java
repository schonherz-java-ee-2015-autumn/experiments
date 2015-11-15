package hu.schonherz.common.dao;

public class PersistenceException extends Exception {

	private static final long serialVersionUID = 2468037641778936562L;

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message) {
		super(message);
	}

}
