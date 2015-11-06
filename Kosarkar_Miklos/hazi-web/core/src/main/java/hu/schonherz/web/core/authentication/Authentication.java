package hu.schonherz.web.core.authentication;

import hu.schonherz.common.Encryption;
import hu.schonherz.common.User;
import hu.schonherz.common.UserManager;
import hu.schonherz.web.core.StrongEncryptor;
import hu.schonherz.web.core.UserManagerImpl;
import hu.schonherz.web.core.validation.Validator;

public class Authentication {
	
	private Authentication(){
		
	}
	public static boolean isSuccessfulAuthentication(String username, String password){
		if(Validator.isValidInput(username) && Validator.isValidInput(password)){
			UserManager um = new UserManagerImpl();
			User user = um.findUserByName(username);
			if(user!=null){
				//StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
				Encryption encryptor = new StrongEncryptor();
				if(encryptor.check(password, user.getPass())){
					return true;
				}else{
					return false;
				}
			}
			return false;
		}else{
			return false;
		}
		
	}
}
