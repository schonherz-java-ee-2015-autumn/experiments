package hu.schonherz.kepzes.java.common;

import javax.sql.DataSource;

public interface CheckerDAO {
	boolean checkUserByUsername(String userName);
	boolean checkUserByEmail(String eMail);
	void setDatabase(DataSource dataSource);
}
