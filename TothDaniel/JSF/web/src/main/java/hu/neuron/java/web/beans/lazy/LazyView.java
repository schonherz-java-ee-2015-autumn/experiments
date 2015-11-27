package hu.neuron.java.web.beans.lazy;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "dtLazyView")
@ViewScoped
public class LazyView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<UserVO> lazyModel;

	private UserVO selectedUser;

	// @ManagedProperty("#{customUserDetailsService}")
	// private CustomUserDetailsService service;
	@EJB
	UserServiceLocal userService;

	@PostConstruct
	public void init() {
		lazyModel = new LazyUserDataModel(userService.getUsers());
	}

	public LazyDataModel<UserVO> getLazyModel() {
		return lazyModel;
	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("User Selected", ((UserVO) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public UserVO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}
}