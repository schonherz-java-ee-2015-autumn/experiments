package hu.schonherz.training.validation.webform.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.validation.Validator;
import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;

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
