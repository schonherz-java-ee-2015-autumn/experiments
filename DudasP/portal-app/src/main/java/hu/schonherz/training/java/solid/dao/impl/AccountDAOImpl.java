package hu.schonherz.training.java.solid.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;

public class AccountDAOImpl implements AccountDAO {
	private String dbFile;

	public AccountDAOImpl(String dbFile) {
		Validate.notBlank(dbFile);
		this.dbFile = dbFile;
	}

	@Override
	public void save(Account account) throws DataAccessException {
		try (FileWriter writer = new FileWriter(dbFile, true)) {
			writer.append(account.getUsername()).append(',').append(account.getEmail()).append(',')
					.append(account.getEncryptedPassword()).append('\n');
		} catch (IOException e) {
			throw new DataAccessException("Unable to save account", e);
		}
	}

	@Override
	public List<Account> getAccounts() {
		// TODO LOL
		return null;
	}

}
