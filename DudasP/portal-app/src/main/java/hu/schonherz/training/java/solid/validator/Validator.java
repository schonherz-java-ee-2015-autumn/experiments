package hu.schonherz.training.java.solid.validator;

public interface Validator<T> {
  void validate(T object) throws ViolationException;
}
