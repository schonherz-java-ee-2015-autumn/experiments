package hu.schonherz.training.registration;

import hu.schonherz.training.exception.ViolationException;

public interface Converter<T> {

	public T convert() throws ViolationException;
	
}
