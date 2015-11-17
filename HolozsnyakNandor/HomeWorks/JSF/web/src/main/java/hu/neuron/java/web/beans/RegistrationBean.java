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
public class RegistrationBean implements Serializable{
	
	
	@ManagedProperty(value="#{userService}")
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
	
	
	public void registration() {
		FacesContext current = FacesContext.getCurrentInstance();
		UserVO user = new UserVO();
		System.out.println("Username:"+username);
		user.setUsername(username);
		user.setPassword(password);
//		if(password == null || passwordConfirm == null && !passwordConfirm.equals(password)) {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Error!","A két jelszónak meg kell egyeznie!!");
//			current.addMessage(null, msg);
//		}
			try {
				userService.registrationUser(user);
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","Hiba a regisztráció közben.");
				current.addMessage(null, msg);
				e.printStackTrace();
			}
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succes!","Sikeres regisztráció!");
			current.addMessage(null, msg);
		
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
	
	
}
