package hu.dupetya.common.account.dao;

import java.util.List;

import hu.dupetya.common.account.model.Account;

public interface AccountDAO {
	public Long save(Account account) throws DataAccessException;

	public Account find(Long id) throws DataAccessException;

	public void update(Account dto) throws DataAccessException;

	public void delete(Long id) throws DataAccessException;

	public List<Account> findAll() throws DataAccessException;
}
