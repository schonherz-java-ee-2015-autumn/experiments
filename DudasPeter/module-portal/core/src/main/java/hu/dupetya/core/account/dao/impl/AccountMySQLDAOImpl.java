package hu.dupetya.core.account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;
import hu.dupetya.core.util.DBUtil;

public class AccountMySQLDAOImpl implements AccountDAO {
	private Connection connection;

	public AccountMySQLDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public Long save(Account account) throws DataAccessException {

		Long res = null;
		PreparedStatement query = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT INTO users(username, pass, email, dob) VALUES (?, ?, ?, ?)";
			query = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			query.setString(1, account.getUsername());
			query.setString(2, account.getEncryptedPassword());
			query.setString(3, account.getEmail());
			query.setDate(4, new java.sql.Date(account.getDateOfBirth().getTime()));

			query.executeUpdate();

			rs = query.getGeneratedKeys();

			if (rs.next()) {
				res = rs.getLong(1);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Error while saving account");
		} finally {
			try {
				query.close();
			} catch (Exception e2) {
			}
			try {
				rs.close();
			} catch (Exception e2) {
			}

		}

		return res;
	}

	@Override
	public Account find(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account account) throws DataAccessException {
		PreparedStatement query = null;

		try {
			String sql = "UPDATE users SET username=?, pass=?, email=?, dob=? where id=?";
			query = connection.prepareStatement(sql);

			query.setString(1, account.getUsername());
			query.setString(2, account.getEncryptedPassword());
			query.setString(3, account.getEmail());
			query.setDate(4, new java.sql.Date(account.getDateOfBirth().getTime()));
			query.setLong(5, account.getId());

			query.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			DBUtil.close(query);
		}

	}

	@Override
	public void delete(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findAll() throws DataAccessException {
		List<Account> res = new ArrayList<>();
		PreparedStatement query = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM users";
			query = connection.prepareStatement(sql);

			rs = query.executeQuery();

			while (rs.next()) {
				Account acc = new Account();

				acc.setEmail(rs.getString("email"));
				acc.setEncryptedPassword(rs.getString("pass"));
				acc.setId(rs.getLong("id"));
				acc.setUsername(rs.getString("username"));
				acc.setDateOfBirth(rs.getDate("dob"));

				res.add(acc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, query);
		}

		return res;
	}

	public List<Account> findCustom(int start, int length, String search, String orderCol, String orderDir)
			throws DataAccessException {
		StringBuilder sb = new StringBuilder("SELECT * FROM users");
		if (!"".equals(search)) {
			sb.append(" ").append("WHERE username LIKE '%").append(search).append("%'");
			sb.append(" OR ").append("email LIKE '%").append(search).append("%'");
		}
		sb.append(" ORDER BY ").append(orderCol).append(" ").append(orderDir);
		sb.append(" LIMIT ").append(start).append(", ").append(length);

		ResultSet rs = null;
		PreparedStatement query = null;
		String sql = sb.toString();
		List<Account> res = new ArrayList<>();

		try {
			query = connection.prepareStatement(sql);
			rs = query.executeQuery();

			while (rs.next()) {
				Account acc = new Account();

				acc.setDateOfBirth(rs.getDate("dob"));
				acc.setEmail(rs.getString("email"));
				acc.setEncryptedPassword(rs.getString("pass"));
				acc.setId(rs.getLong("id"));
				acc.setUsername(rs.getString("username"));

				res.add(acc);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			DBUtil.close(rs, query);
		}

		return res;
	}

}
