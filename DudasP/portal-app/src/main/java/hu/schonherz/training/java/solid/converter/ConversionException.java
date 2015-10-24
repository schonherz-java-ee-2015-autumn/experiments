package hu.schonherz.training.java.solid.converter;

public class ConversionException extends Exception {

  public ConversionException(String message) {
    super(message);
  }

  public ConversionException(Throwable cause) {
    super(cause);
  }

  public ConversionException(String message, Throwable cause) {
    super(message, cause);
  }

}
