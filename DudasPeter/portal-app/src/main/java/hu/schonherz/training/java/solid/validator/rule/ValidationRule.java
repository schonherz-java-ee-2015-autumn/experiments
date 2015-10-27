package hu.schonherz.training.java.solid.validator.rule;

import java.util.List;

import hu.schonherz.training.java.solid.validator.Violation;

public interface ValidationRule<T> {

  List<Violation> validate(T object);

}
