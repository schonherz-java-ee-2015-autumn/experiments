package hu.schonherz.kepzes.java.core.tools;

import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Encryptor implements PasswordEncryptor {
	@Autowired
	private StrongPasswordEncryptor strongPassword;

	public Encryptor() {

	}

	public String encryptPassword(String password) {
		return strongPassword.encryptPassword(password);
	}

	@Override
	public boolean checkPassword(String arg0, String arg1) {
		if (arg0 == arg1) {
			return true;
		} else {
			return false;
		}
	}

}
