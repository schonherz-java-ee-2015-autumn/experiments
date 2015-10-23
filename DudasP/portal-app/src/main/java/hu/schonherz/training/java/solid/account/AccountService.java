package hu.schonherz.training.java.solid.account;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.validator.ViolationException;

public interface AccountService {
  Account register(AccountRegistrationRequest request) throws ViolationException,
      AccountRegistrationException;
}
