package hu.dupetya.common.account;

import hu.dupetya.common.account.model.Account;

public interface AccountService {
	Account register(AccountRegistrationRequest request) throws AccountRegistrationException;
}
