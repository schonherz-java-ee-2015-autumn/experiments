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

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		UserVO user = new UserVO();
		System.out.println("Username:" + username);
		user.setUsername(username);
		user.setPassword(password);
		UserVO userVO = new UserVO();
		boolean success = false;
		try {
			userVO = userService.loginUser(user);
			if (userVO != null) {
				context.getExternalContext().getSessionMap().put("user", userVO);
				success = true;
			}

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		if (success) {
			return "user";
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "Login failed!");
			context.addMessage(null, msg);
			return "error";
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
