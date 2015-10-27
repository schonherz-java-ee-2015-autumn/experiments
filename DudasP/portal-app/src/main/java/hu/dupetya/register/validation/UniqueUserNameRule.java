package hu.dupetya.register.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

public class UniqueUserNameRule implements ValidationRule<AccountRegistrationRequest> {
	private List<String> usernames;

	public UniqueUserNameRule(List<String> usernames) {
		super();
		this.usernames = usernames;
	}

	@Override
	public List<Violation> validate(AccountRegistrationRequest request) {

		for (String username : usernames) {
			if (username.equals(request.getUsername())) {
				return Arrays.asList(new Violation("username", "Username must be unique"));
			}
		}
		return Collections.emptyList();
	}

}
