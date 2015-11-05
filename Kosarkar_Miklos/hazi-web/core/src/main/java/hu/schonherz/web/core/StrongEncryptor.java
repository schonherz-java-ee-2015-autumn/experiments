package hu.schonherz.web.core;

import org.jasypt.util.password.StrongPasswordEncryptor;

import hu.schonherz.common.Encryption;

public class StrongEncryptor implements Encryption {
	private StrongPasswordEncryptor passwordEncryptor;

	public StrongEncryptor() {
		passwordEncryptor = new StrongPasswordEncryptor();
	}

	@Override
	public String encrypt(String toEncrypt) {
		return passwordEncryptor.encryptPassword(toEncrypt);
		
	}

	@Override
	public boolean check(String input, String actualPwd) {

		if (passwordEncryptor.checkPassword(input, actualPwd)) {
			return true;
		} else {
			return false;
		}
	}

}
