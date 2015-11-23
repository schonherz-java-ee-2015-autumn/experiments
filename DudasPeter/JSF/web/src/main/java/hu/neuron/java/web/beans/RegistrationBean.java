package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean implements Serializable {

	@EJB
	private UserServiceLocal userService;

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String passwordConfirm;

	public void registration() {
		FacesContext currentInstance = FacesContext.getCurrentInstance();

		UserVO userVO = new UserVO();
		userVO.setUsername(username);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		userVO.setPassword(bCryptPasswordEncoder.encode(password));

		if (password == null || passwordConfirm == null || !password.equals(passwordConfirm)) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erorr!", "Wrong passwords!");
			currentInstance.addMessage(null, facesMessage);
			return;
		}
		try {
			getUserService().registrationUser(userVO);
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erorr!", "Erorr in saveaction!");
			currentInstance.addMessage(null, facesMessage);
			e.printStackTrace();
		}

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes registration!");
		currentInstance.addMessage(null, facesMessage);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

}
