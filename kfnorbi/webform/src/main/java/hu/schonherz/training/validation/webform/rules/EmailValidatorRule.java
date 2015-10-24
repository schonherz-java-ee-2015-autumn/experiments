package hu.schonherz.training.validation.webform.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.EmailValidator;

import hu.schonherz.training.validation.Validator;
import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;

public class EmailValidatorRule implements Validator<PersonRegistrationRequest> {

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		// TODO Auto-generated method stub
		EmailValidator validator = EmailValidator.getInstance();
		return StringUtils.isBlank(object.getEmail()) || validator.isValid(object.getEmail())
				? Collections.<Violation> emptyList() : Arrays.asList(new Violation("email", "Invalid email address"));
	}

}
