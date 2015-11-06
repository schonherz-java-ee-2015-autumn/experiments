package hu.schonherz.training.validation.rulesimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.EmailValidator;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.validation.Validator;

public class EmailValidatorRule implements Validator<PersonRegistrationRequest> {

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		// TODO Auto-generated method stub
		EmailValidator validator = EmailValidator.getInstance();
		return StringUtils.isNotBlank(object.getEmail()) && validator.isValid(object.getEmail())
				? Collections.<Violation> emptyList() : Arrays.asList(new Violation("email", "Invalid email address"));
	}

}
