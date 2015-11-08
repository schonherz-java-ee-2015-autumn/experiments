package hu.schonherz.training.validation;

import java.util.List;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;

public interface Validator<T> {

	public List<Violation> validate(T object) throws ViolationException;
	
}
