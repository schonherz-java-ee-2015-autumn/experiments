package hu.schonhercz.web;

public class Validate {
	
	public static String validator(String userName, String password, String fullName, String eMail, String birthPlace, String bornDate) {
		for(Account ac : Account.getAccountDB()) {
			if(userName.equals(ac.getUserName())) {
				return "már van ilyen felhasználó!";
			}
		}
		return "OK";
	}

}
