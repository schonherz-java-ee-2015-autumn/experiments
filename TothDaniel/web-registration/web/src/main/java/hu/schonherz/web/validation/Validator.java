package hu.schonherz.web.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validator {
	public static final String DATEFORMAT = "MM/dd/yyyy";
	public static boolean isValidDate(String date, String format) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isValidEmailAddress(String email) {
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
	
	public static boolean isValidInput(String input){
		if(input!=null && input.isEmpty()){
			return false;
		}else {
			return true;
		}
	}
}
