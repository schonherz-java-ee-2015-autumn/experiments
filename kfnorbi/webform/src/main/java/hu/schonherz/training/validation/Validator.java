package hu.schonherz.training.validation;

import java.util.List;

public interface Validator<T> {

	public List<Violation> validate(T object) throws ViolationException;
	
}
