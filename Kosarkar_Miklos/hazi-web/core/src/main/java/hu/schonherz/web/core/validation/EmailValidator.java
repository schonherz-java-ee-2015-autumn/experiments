package hu.schonherz.web.core.validation;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import hu.schonherz.common.Validator;

public class EmailValidator implements Validator {
	private String email;

	public EmailValidator(String email) {
		this.email = email;
	}

	@Override
	public boolean validate() {
		if (email == null || email.equals("")) {
			return false;
		} else {
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
				return true;
			} catch (AddressException ex) {
				return false;
			}
		}
	}

}
