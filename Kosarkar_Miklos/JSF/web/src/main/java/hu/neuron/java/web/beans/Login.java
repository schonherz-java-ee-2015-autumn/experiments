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

@ManagedBean(name = "loginBean")
@ViewScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// autowired nem működik jsf kell mert a springes nem jó külön futnak
	// az el resolver a springes beameket is felszedi

	@ManagedProperty("#{userService}")
	private UserService userService;

	@ManagedProperty("#{userSessionBean}")
	private UserSession userSession;

	// ezek a mezők rá lesznek bindolva
	private String username;
	private String password;

	public void login() {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		UserVO userVO = new UserVO();
		userVO.setUsername(username);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		UserVO tempUserVO = null;
		userVO.setPassword(bc.encode(password));

		if (password != null)
			try {

				if ((tempUserVO = userService.findUserByName(userVO.getUsername())) != null
						&& bc.matches(password, tempUserVO.getPassword())) {
					userSession.setCurrentUser(userVO);

					FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres Bejelentkezés!",
							"");
					currentInstance.addMessage(null, facesMessage);
					FacesContext.getCurrentInstance().getExternalContext().redirect("/WebApp/public/chat.xhtml");

				} else {
					FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Nem megfelelő felhasználónév vagy jelszó", "");
					currentInstance.addMessage(null, facesMessage);
				}

			} catch (Exception e) {
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Error mentés közben.");
				currentInstance.addMessage(null, facesMessage);
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

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

}
