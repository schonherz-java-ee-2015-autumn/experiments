package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean
@ViewScoped
public class RegistrationBean implements Serializable {

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String passwordConfirm;
	private String passConf = "";
	private String fullname;
	private String email;
	private boolean checkPasswords;

	

	public void registration() {
		FacesContext current = FacesContext.getCurrentInstance();
		UserVO user = new UserVO();
		System.out.println("Username:" + username);

		if (password == null || passwordConfirm == null) {
			/*FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba",
					"A két jelszónak meg kell egyeznie!");
			current.addMessage(null, msg);*/

		} else if (!passwordConfirm.equals(password)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "A két jelszónak meg kell egyeznie!",
					"A két jelszónak meg kell egyeznie!");
			current.addMessage(null, msg);

		} else {
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setFullname(fullname);
			try {
				userService.registrationUser(user);
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba a regisztráció közben!",
						"Hiba a regisztráció közben.");
				current.addMessage(null, msg);
				e.printStackTrace();
			}
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres regisztráció!",
					"Sikeres regisztráció!");
			current.addMessage(null, msg);

		}
	}

	public void checkPasswords() {
		if (!password.equals(passwordConfirm)) {
			passConf = "A két jelszónak eggyezni kell!";
		} else {
			passConf = "";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String usename) {
		this.username = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassConf() {
		return passConf;
	}

	public void setPassConf(String passConf) {
		this.passConf = passConf;
	}

	public boolean isCheckPasswords() {
		return checkPasswords;
	}

	public void setCheckPasswords(boolean checkPasswords) {
		this.checkPasswords = checkPasswords;
	}
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
