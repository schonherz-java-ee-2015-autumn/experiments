package hu.schonherz.training.validation.webform.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.validation.Validator;
import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;

public class PhoneNumberRule implements Validator<PersonRegistrationRequest> {

	public PhoneNumberRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {

		return StringUtils.isNotBlank(object.getPhoneNumber()) && object.getPhoneNumber().trim().matches("\\+?[{10}[0-9]][0-9]+") ? Collections.emptyList()
				: Arrays.asList(new Violation("phonenumber", "This phone number is not valid"));
	}

}
