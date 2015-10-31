package hu.schonherz.training.java.solid.account.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.Validate;

import hu.dupetya.common.account.AccountRegistrationRequest;
import hu.dupetya.common.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.EncryptionException;
import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.converter.Converter;

public class AccountRegistrationRequestToAccountConverter implements Converter<AccountRegistrationRequest, Account> {

	private CipherService cipherService;

	public AccountRegistrationRequestToAccountConverter(CipherService cipherService) {
		Validate.notNull(cipherService);
		this.cipherService = cipherService;
	}

	@Override
	public Account convert(AccountRegistrationRequest source) throws ConversionException {
		try {
			Validate.notNull(source);

			Account account = new Account();
			account.setUsername(source.getUsername());
			account.setEmail(source.getEmail());
			String encryptedPassword = cipherService.encrypt(source.getPassword());
			account.setEncryptedPassword(encryptedPassword);
			account.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(source.getDateOfBirth()));
			return account;
		} catch (EncryptionException | ParseException e) {
			throw new ConversionException("Could not convert account registration request to account", e);
		}
	}

}
