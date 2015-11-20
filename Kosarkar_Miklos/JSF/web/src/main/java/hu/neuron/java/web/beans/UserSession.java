package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSession implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserVO currentUser;
	
	public UserVO getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(UserVO currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
