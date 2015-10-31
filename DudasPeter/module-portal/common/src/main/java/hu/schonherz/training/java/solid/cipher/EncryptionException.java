package hu.schonherz.training.java.solid.cipher;

public class EncryptionException extends CipherException {

	private static final long serialVersionUID = -430374664356158151L;

	public EncryptionException(String message) {
		super(message);
	}

	public EncryptionException(Throwable cause) {
		super(cause);
	}

	public EncryptionException(String message, Throwable cause) {
		super(message, cause);
	}

}
