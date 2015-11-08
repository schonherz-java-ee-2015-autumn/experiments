package hu.schonherz.training.validation.rulesimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.validation.Validator;

public class PasswordValidationRule implements Validator<PersonRegistrationRequest> {

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		return StringUtils.isNotBlank(object.getPassword()) && object.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")?
				Collections.emptyList():Arrays.asList(new Violation("password","The password must contain at least an uppercase letter, a lower letter, and a number"));
	}

	
}
