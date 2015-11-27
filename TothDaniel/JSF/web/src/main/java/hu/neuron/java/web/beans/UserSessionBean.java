package hu.neuron.java.web.beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.UserVO;

@SessionScoped
@ManagedBean(name = "userSessionBean")
public class UserSessionBean {

	@EJB
	private UserServiceLocal userService;

	private UserVO userVO;

	@PostConstruct
	public void init() {

		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			if (userVO == null) {
				userVO = null;
				Principal principal = req.getUserPrincipal();
				if (principal != null) {
					String userName = principal.getName();
					try {
						userVO = getUserService().findUserByName(userName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
		}

	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}
}
