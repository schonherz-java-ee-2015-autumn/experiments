package hu.schonherz.training.validation.webform.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.validation.Validator;
import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;

public class LocationValidatorRule implements Validator<PersonRegistrationRequest> {

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		return StringUtils.isNotBlank(object.getCity())?Collections.emptyList():Arrays.asList(new Violation("city","Please enter a valid city"));
	}

}
