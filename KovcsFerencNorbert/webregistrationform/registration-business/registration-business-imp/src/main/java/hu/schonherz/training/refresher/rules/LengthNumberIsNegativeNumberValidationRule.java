package hu.schonherz.training.refresher.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.validation.Validator;

public class LengthNumberIsNegativeNumberValidationRule implements Validator<RefreshRequest> {

	@Override
	public List<Violation> validate(RefreshRequest object) throws ViolationException {
		return object.getLength() < 0
				? Arrays.asList(new Violation("length", "The length number can not be a negative number"))
				: Collections.<Violation> emptyList();
	}

}
