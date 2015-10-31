package hu.dupetya.common.account;

public class AccountRegistrationException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -8605500783540620064L;

	public AccountRegistrationException(String message) {
		super(message);
	}

	public AccountRegistrationException(Throwable cause) {
		super(cause);
	}

	public AccountRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

}
