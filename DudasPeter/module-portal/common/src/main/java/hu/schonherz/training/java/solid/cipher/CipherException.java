package hu.schonherz.training.java.solid.cipher;

public class CipherException extends Exception {

	private static final long serialVersionUID = 1532477816732028980L;

	public CipherException(String message) {
		super(message);
	}

	public CipherException(Throwable cause) {
		super(cause);
	}

	public CipherException(String message, Throwable cause) {
		super(message, cause);
	}

}
