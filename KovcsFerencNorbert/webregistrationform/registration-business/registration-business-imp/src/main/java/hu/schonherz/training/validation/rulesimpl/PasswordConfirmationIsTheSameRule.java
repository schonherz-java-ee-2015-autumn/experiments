package hu.schonherz.training.validation.rulesimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.validation.Validator;

public class PasswordConfirmationIsTheSameRule implements Validator<PersonRegistrationRequest> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.schonherz.training.validation.Validator#validate(java.lang.Object)
	 */
	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		return StringUtils.isNotBlank(object.getPasswordConfirmation())
				&& object.getPassword().equals(object.getPasswordConfirmation()) ? Collections.emptyList()
						: Arrays.asList(new Violation("confirmpassword", "The passwords do not match"));
	}

}
