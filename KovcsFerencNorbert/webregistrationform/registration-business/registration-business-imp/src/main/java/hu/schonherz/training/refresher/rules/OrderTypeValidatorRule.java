package hu.schonherz.training.refresher.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.validation.Validator;

public class OrderTypeValidatorRule implements Validator<RefreshRequest> {

	@Override
	public List<Violation> validate(RefreshRequest object) throws ViolationException {

		Set<String> ascDesc = new HashSet<String>(Arrays.asList("ASC,DESC"));
		
		return ascDesc.contains(object.getOrderType().toUpperCase())?Arrays.asList(new Violation("ordertype","OrderType is neither \"ASC\" or \"DSC\"")):Collections.<Violation>emptyList();
	}

}
