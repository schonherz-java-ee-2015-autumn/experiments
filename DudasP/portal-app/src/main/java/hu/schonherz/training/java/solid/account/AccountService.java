package hu.schonherz.training.java.solid.account;

import hu.schonherz.training.java.solid.account.model.Account;

public interface AccountService {
	Account register(AccountRegistrationRequest request) throws AccountRegistrationException;
}
