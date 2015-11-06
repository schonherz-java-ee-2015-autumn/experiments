package hu.schonherz.training.refresher.rules;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.validation.Validator;

public class OrderColumnNameValidatorRule implements Validator<RefreshRequest> {

	@Override
	public List<Violation> validate(RefreshRequest object) throws ViolationException {
		Set<String> columns = new HashSet<String>(
				Arrays.asList("name", "title", "username", "phonenumber", "email", "city", "dateofbirth"));

		return StringUtils.isNotBlank(object.getOrderBy()) && columns.contains(object.getOrderBy().toLowerCase())
				? Collections.<Violation> emptyList()
				: Arrays.asList(
						new Violation("ordercolumn", "This column is not valid, you cant order the table by it."));
	}

}
