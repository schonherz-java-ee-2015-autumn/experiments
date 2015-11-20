package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean
@ViewScoped
public class ReadUserDetailsBean implements Serializable {

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserVO> getUsers() {
		try {
			return userService.getAllUsers();
		} catch (Exception e) {
			System.out.println("Exception caught while getting userlist!");
		}
		return null;
		
	}
	
	public void modify() {
		UserVO updatedUser = selectedUser;
		
		userService.updateUser(updatedUser);
		System.out.println("selectedUser:" + selectedUser.toString());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserVO selectedUser;
	private List<UserVO> users;
	
	public void onRowSelect(SelectEvent event) {
		selectedUser = (UserVO) event.getObject();
		
    }
 
    public void onRowUnselect(UnselectEvent event) {
    	selectedUser = null;
    }

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	public UserVO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}

    
}
