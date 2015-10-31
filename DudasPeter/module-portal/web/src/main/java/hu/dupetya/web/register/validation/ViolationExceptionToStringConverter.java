package hu.dupetya.web.register.validation;

import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.converter.Converter;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class ViolationExceptionToStringConverter implements Converter<ViolationException, String> {

	@Override
	public String convert(ViolationException source) throws ConversionException {
		StringBuilder sb = new StringBuilder();

		for (Violation violation : source.getViolations()) {
			sb.append(violation.getError()).append(System.lineSeparator());
		}

		return sb.toString();
	}

}