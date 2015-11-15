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
public class LoginBean implements Serializable {

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

	public void login() {
		FacesContext current = FacesContext.getCurrentInstance();
		UserVO user = new UserVO();
		System.out.println("Username:" + username);
		user.setUsername(username);
		user.setPassword(password);
		boolean succes = false;
		try {
			succes = userService.loginUser(user);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exception!!", "Hiba a bejelentkezés közben.");
			current.addMessage(null, msg);
			e.printStackTrace();
		}
		if (succes) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres bejelentkezés!",
					"Sikeres bejelentkezés!");
			current.addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen bejeletnkezés",
					"Sikertelen bejelentkezés!");
			current.addMessage(null, msg);
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

}
