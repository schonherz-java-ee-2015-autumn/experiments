
package hu.schonherz.training.registrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.connector.ConnectionDataPool;
import hu.schonherz.training.person.BeanFactory;
import hu.schonherz.training.person.BeanParser;
import hu.schonherz.training.person.Person;
import hu.schonherz.training.person.PublicPerson;
import hu.schonherz.training.refresher.RefreshParams;

public class PersonRegister implements DataHandlerDAO {

	public boolean isOccupied(String userName) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionDataPool.getConnection();
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			String query = SQLStatementFactory.getUserNameOccupiedStatement();
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			rs = statement.executeQuery();
			return rs.first();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

			}
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}

		return true;
	}

	public List<PublicPerson> getAllUsers(RefreshParams request) {

		List<PublicPerson> result = new ArrayList<PublicPerson>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionDataPool.getConnection();
			String query = SQLStatementFactory.getAllUsersStatement(request);
			// System.out.println(query);
			statement = connection.prepareStatement(query);

			rs = statement.executeQuery();

			while (rs.next()) {
				final ResultSet localResultSet = rs;
				BeanFactory<PublicPerson> personFactory = new BeanFactory<PublicPerson>(new BeanParser<PublicPerson>() {

					@Override
					public PublicPerson parse() {
						try {

							return new PublicPerson(localResultSet.getString("username"),
									localResultSet.getString("name"), localResultSet.getString("dateofbirth"),
									localResultSet.getString("email"), localResultSet.getString("phonenumber"),
									localResultSet.getString("city"));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}
				});

				result.add(personFactory.getInstance());
			}

		} catch (SQLException e) {
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {

			}
		}

		return result;
	}

	// TODO change it to use database
	public Long register(Person p) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionDataPool.getConnection();
			connection.setAutoCommit(true);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			String query = SQLStatementFactory.getRegisterStatement();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			// username,title,firstname,lastname,passwd,city,dateofbirth,phonenumber,email

			statement.setString(1, p.getUserName());
			statement.setString(2, p.getTitle());
			statement.setString(3, p.getFirstName());
			statement.setString(4, p.getLastName());
			statement.setString(5, p.getPassword());
			statement.setString(6, p.getCity());
			statement.setString(7, p.getDateOfBirth());
			statement.setString(8, p.getPhoneNumber());
			statement.setString(9, p.getEmail());

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			// connection.commit();

			if (rs.first()) {
				return rs.getLong(1);
			}

		} catch (SQLException e) {
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {

			}
		}
		return null;

	}

	@Override
	public void update(Person person) throws NullPointerException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionDataPool.getConnection();
			connection.setAutoCommit(true);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			String query = SQLStatementFactory.updateUserStatement();
			statement = connection.prepareStatement(query);

			statement.setLong(1, person.getId());

			statement.executeQuery();

		} catch (SQLException e) {
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public void delete(Person person) throws NullPointerException {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionDataPool.getConnection();
			connection.setAutoCommit(true);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			String query = SQLStatementFactory.getDeleteStatement();
			statement = connection.prepareStatement(query);

			statement.setLong(1, person.getId());

			statement.executeQuery();

		} catch (SQLException e) {
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}

	}

}
