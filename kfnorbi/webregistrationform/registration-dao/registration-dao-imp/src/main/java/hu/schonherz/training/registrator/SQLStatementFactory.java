package hu.schonherz.training.registrator;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.refresher.RefreshParams;

public class SQLStatementFactory {

	public static String getUserNameOccupiedStatement() {
		return "SELECT id FROM users WHERE username = ?;";
	}

	public static String getRegisterStatement() {
		final String SQL = "INSERT INTO users(username,title,firstname,lastname,passwd,city,dateofbirth,phonenumber,email)"
				+ "VALUES(?,?,?,?,?,?,?,?,?);";

		return SQL;
	}

	public static String getDeleteStatement() {
		return "DELETE FROM users WHERE id = ?;";
	};

	public static String getAllUsersStatement(RefreshParams params) {

		String searcField = StringUtils.isNotBlank(params.getSearchExpression())
				? " WHERE name LIKE '%" + params.getSearchExpression() + "%' OR "
						+ "username LIKE '%" + params.getSearchExpression() + "%' OR " + "email LIKE '%"
						+ params.getSearchExpression() + "%' OR " + "phonenumber LIKE '%" + params.getSearchExpression() + "%'"
				: "";

		return "SELECT CONCAT_WS(' ',title,firstname,lastname) as name, city,email,phonenumber,dateofbirth,username FROM users"
				+ searcField + " ORDER BY " + params.getOrderBy() + " " + params.getOrderType() + " LIMIT "
				+ params.getStart() + "," + Integer.toString(params.getStart() + params.getLength()) + ";";
	}

	public static String updateUserStatement() {
		return "UPDATE users WHERE id = ? SET title = ?," + "firstname = ?, " + "lastname = ?, " + "passwd = ?, "
				+ "email = ?, " + "phonenumber = ?," + " dateofbirth = ?," + " city = ?;";
	}

}
