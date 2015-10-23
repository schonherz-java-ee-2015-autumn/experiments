package hu.dupetya.register;

import java.util.Collections;

import javax.servlet.http.HttpServlet;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.impl.AccountServiceImpl;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.impl.CipherServiceImpl;
import hu.schonherz.training.java.solid.converter.Converter;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

public class RegistrationFactory {
	private static final String KEY = "+d/Hd+CIMj/ochQmEcLGTg==";
	private static final String IV = "WVyENBxRsmHQyYJWWahmfg==";

	private AccountService accountService;
	private Converter<AccountRegistrationRequest, Account> converter;
	private CipherService cipherService;
	private AccountDAO accountDAO;
	private Validator<AccountRegistrationRequest> validator;

	public RegistrationFactory(HttpServlet servlet) {
		cipherService = new CipherServiceImpl(KEY, IV);
		converter = new AccountRegistrationRequestToAccountConverter(cipherService);

		accountDAO = new AccountServletDAO(servlet);
		validator = new RuleValidator<>(Collections.emptyList());

		accountService = new AccountServiceImpl(accountDAO, validator, converter);
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public Converter<AccountRegistrationRequest, Account> getConverter() {
		return converter;
	}

	public CipherService getCipherService() {
		return cipherService;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public Validator<AccountRegistrationRequest> getValidator() {
		return validator;
	}

}
