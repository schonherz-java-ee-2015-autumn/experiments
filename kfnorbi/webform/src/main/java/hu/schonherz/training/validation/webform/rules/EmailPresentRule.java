package hu.schonherz.training.validation.webform.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.validation.Validator;
import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;

public class EmailPresentRule implements Validator<PersonRegistrationRequest> {

	public EmailPresentRule() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.schonherz.training.validation.Validator#validate(java.lang.Object)
	 */
	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		return StringUtils.isBlank(object.getEmail())? Arrays.asList(new Violation("email", "An e-mail address must be entered")) : Collections.emptyList();
	}

}
