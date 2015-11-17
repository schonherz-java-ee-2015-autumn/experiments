package hu.schonherz.webapp;

public final class UserValidator {
	
	public static boolean isValidUsername(String name){
		if(User.findUser(name)!=null)
			return false;
		return true;
	}
	
	public static boolean isValidPass(String pwd,String pwd2){
		return (pwd.length()>=8 && pwd.equals(pwd2));
	}
	
	public static boolean isValidDate(String date){
		if(date.matches("[0-2][0-9]{3}.[0-1][0-9].[0-3][0-9]"))
			return true;
		return false;
	}
	
	public static boolean isValidEmail(String email){
		if(email.contains("@") && email.contains("."))
			return true;
		return false;
		
	}

}
