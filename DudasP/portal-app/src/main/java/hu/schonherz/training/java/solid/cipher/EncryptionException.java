package hu.schonherz.training.java.solid.cipher;

public class EncryptionException extends CipherException {

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
