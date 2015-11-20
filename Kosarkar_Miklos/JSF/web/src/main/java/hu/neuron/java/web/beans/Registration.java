package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class Registration implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// autowired nem működik jsf kell mert a springes nem jó külön futnak
	// az el resolver a springes beameket is felszedi
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	
	// ezek a mezők rá lesznek bindolva
	private String username;
	private String password;
	private String passwordConfirmation;
	
	public void registration(){
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		UserVO userVO = new UserVO();
		userVO.setUsername(username);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		userVO.setPassword(bc.encode(password));
		
		if(password!=null || password.equals(passwordConfirmation))
		try {
			userService.registrationUser(userVO);
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success volt",
					"Siker mámor öröm");
			currentInstance.addMessage(null, facesMessage);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/WebApp/public/login.xhtml");
			
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Részletes Error mentés közben");
			currentInstance.addMessage(null, facesMessage);
			
		}
		else{
			
		}
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	
}
