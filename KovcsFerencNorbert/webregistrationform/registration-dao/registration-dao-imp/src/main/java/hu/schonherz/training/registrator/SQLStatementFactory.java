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
		StringBuffer buffer = new StringBuffer();

		String searcField = StringUtils.isNotBlank(params.getSearchExpression())
				? " WHERE name LIKE '%[replacewithparam]%' OR username LIKE '%[replacewithparam]%' OR email LIKE '%[replacewithparam]%' OR phonenumber LIKE '%[replacewithparam]%'"
						.replaceAll("[replacewithparam]", params.getSearchExpression())
				: "";

		buffer.append(
				"SELECT CONCAT_WS(' ',title,firstname,lastname) as name, city,email,phonenumber,dateofbirth,username FROM users ");
		buffer.append(searcField);
		buffer.append(" ORDER BY ");
		buffer.append(params.getOrderBy() + " " + params.getOrderType());
		buffer.append(" LIMIT ?,?;");

		return buffer.toString();
	}

	public static String updateUserStatement() {
		return "UPDATE users WHERE id = ? SET title = ?," + "firstname = ?, " + "lastname = ?, " + "passwd = ?, "
				+ "email = ?, " + "phonenumber = ?," + " dateofbirth = ?," + " city = ?;";
	}

}
