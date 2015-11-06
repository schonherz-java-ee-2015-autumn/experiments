package hu.schonherz.training.validation.rulesimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.registrator.DataHandlerDAO;
import hu.schonherz.training.registrator.PersonRegister;
import hu.schonherz.training.validation.Validator;

public class UserNameOccupiedRule implements Validator<PersonRegistrationRequest> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.schonherz.training.validation.Validator#validate(java.lang.Object)
	 */
	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		DataHandlerDAO register = new PersonRegister();
		return StringUtils.isNotBlank(object.getUserName()) && !register.isOccupied(object.getUserName())
				? Collections.emptyList()
				: Arrays.asList(new Violation("username", "This username is already occupied"));
	}

}
