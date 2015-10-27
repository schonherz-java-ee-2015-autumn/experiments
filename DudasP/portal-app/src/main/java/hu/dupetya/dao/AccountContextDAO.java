package hu.dupetya.dao;

import java.util.List;

import javax.servlet.ServletContext;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;

public class AccountContextDAO implements AccountDAO {

	private List<Account> accounts;

	@SuppressWarnings("unchecked")
	public AccountContextDAO(ServletContext servletContext) {
		accounts = (List<Account>) servletContext.getAttribute("users");
	}

	@Override
	public void save(Account account) throws DataAccessException {
		accounts.add(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

}
