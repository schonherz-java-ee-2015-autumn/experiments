package hu.dupetya.register;

import java.util.List;

import javax.servlet.http.HttpServlet;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;

@SuppressWarnings("unchecked")
public class AccountServletDAO implements AccountDAO {
	private static final String USERSSTR = "users";
	private HttpServlet servlet;

	public AccountServletDAO(HttpServlet servlet) {
		super();
		this.servlet = servlet;
	}

	@Override
	public void save(Account account) throws DataAccessException {
		List<Account> accounts = (List<Account>) servlet.getServletContext().getAttribute(USERSSTR);

		accounts.add(account);
	}
}
