package hu.schonherz.kepzes.java.common;

public interface CheckerDAO {
	boolean checkUserByUsername(String userName);
	boolean checkUserByEmail(String eMail);
}
