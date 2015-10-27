package hu.schonherz.training.java.solid.dao;

import java.util.List;

import hu.schonherz.training.java.solid.account.model.Account;

public interface AccountDAO {
	void save(Account account) throws DataAccessException;

	List<Account> getAccounts();
}
