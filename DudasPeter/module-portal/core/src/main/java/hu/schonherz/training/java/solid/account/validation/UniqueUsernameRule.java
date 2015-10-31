package hu.schonherz.training.java.solid.account.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hu.dupetya.common.account.AccountRegistrationRequest;
import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

public class UniqueUsernameRule implements ValidationRule<AccountRegistrationRequest> {
	private AccountDAO dao;

	public UniqueUsernameRule(AccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Violation> validate(AccountRegistrationRequest aRequest) {
		try {
			for (Account account : dao.findAll()) {
				if (account.getUsername().equals(aRequest.getUsername())) {
					return Arrays.asList(new Violation("username", "Username already exists"));
				}
			}
		} catch (DataAccessException e) {
		}
		return Collections.emptyList();
	}

}
