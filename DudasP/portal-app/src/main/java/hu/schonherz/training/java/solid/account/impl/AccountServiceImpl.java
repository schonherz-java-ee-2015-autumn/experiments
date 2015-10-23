package hu.schonherz.training.java.solid.account.impl;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.AccountRegistrationException;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.converter.Converter;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class AccountServiceImpl implements AccountService {

  private AccountDAO accountDAO;
  private Validator<AccountRegistrationRequest> validator;
  private Converter<AccountRegistrationRequest, Account> converter;

  public AccountServiceImpl(AccountDAO accountDAO, Validator<AccountRegistrationRequest> validator,
      Converter<AccountRegistrationRequest, Account> converter) {
    Validate.notNull(accountDAO);
    Validate.notNull(validator);
    Validate.notNull(converter);

    this.accountDAO = accountDAO;
    this.validator = validator;
    this.converter = converter;
  }

  @Override
  public Account register(AccountRegistrationRequest request) throws ViolationException,
      AccountRegistrationException {
    try {
      Validate.notNull(request, "Registration request cannot be null");
      this.validator.validate(request);
      Account account = this.converter.convert(request);
      this.accountDAO.save(account);
      return account;
    } catch (DataAccessException | ConversionException e) {
      throw new AccountRegistrationException("Could not register user", e);
    }
  }

}
