package hu.dupetya.core.account.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import hu.dupetya.common.account.dao.DAOException;
import hu.dupetya.core.account.dao.impl.AccountMySQLDAOImpl;
import hu.dupetya.core.connection.Datasource;
import hu.dupetya.core.util.DBUtil;

public class DAOFactory {
	private Connection connection;
	private AccountMySQLDAOImpl dao;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	public AccountMySQLDAOImpl getAccountMySQLDAO() throws DAOException {
		if (dao == null) {
			dao = new AccountMySQLDAOImpl(connection);
		}
		return dao;
	}

	public void beginConnection() throws DAOException {
		try {
			connection = Datasource.getInstance().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException | NamingException e) {
			throw new DAOException(e);
		}
	}

	public void beginTransaction() throws DAOException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void endTransaction() throws DAOException {
		try {
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void abortTransaction() throws DAOException {
		try {
			connection.rollback();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void endConnection() {
		if (connection != null) {
			DBUtil.close(connection);
		}
	}

}
