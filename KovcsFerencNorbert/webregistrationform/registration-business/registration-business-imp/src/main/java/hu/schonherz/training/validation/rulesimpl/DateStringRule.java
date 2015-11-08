	package hu.schonherz.training.validation.rulesimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.validation.Validator;

public class DateStringRule implements Validator<PersonRegistrationRequest> {

	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {

		SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");

		if (StringUtils.isNotBlank(object.getDateOfBirth())) {

			try {
				format.parse(object.getDateOfBirth());
				return Collections.<Violation>emptyList();
			} catch (ParseException e) {
			}

		}
		return Arrays.asList(new Violation("dateofbirth", "This is a not a valid date"));

	}

}
