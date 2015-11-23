package hu.neuron.java.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import hu.neuron.java.service.MessageServiceLocal;
import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean
@ViewScoped
public class MessagesBean {

	private UserVO fromUser;

	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@EJB
	private UserServiceLocal userService;

	@EJB
	private MessageServiceLocal messageService;

	private List<UserVO> users;

	private UserVO selectedUser;

	private String content;

	@PostConstruct
	public void init() {
		fromUser = getUserSessionBean().getUserVO();
		if (fromUser == null) {
			getUserSessionBean().init();
			fromUser = getUserSessionBean().getUserVO();
		}

		users = getUserService().getUsers();
		users.remove(users.indexOf(fromUser));
	}

	public void send() {
		if (content != null && !content.isEmpty()) {
			MessageVO messageVO = new MessageVO();
			messageVO.setSendUser(fromUser);
			messageVO.setTargetUser(selectedUser);

			messageVO.setContent(getContent());
			getMessageService().send(messageVO);
			content = "";
		}
	}

	public void selectUser(UserVO userVO) {
		selectedUser = userVO;
	}

	public List<MessageVO> getMessages() {
		if (selectedUser == null) {
			return new ArrayList<>();
		}
		List<MessageVO> messages = getMessageService().getMessages(fromUser.getId(), selectedUser.getId());

		return messages;
	}

	public UserVO getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserVO fromUser) {
		this.fromUser = fromUser;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

	public MessageServiceLocal getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageServiceLocal messageService) {
		this.messageService = messageService;
	}

	public List<UserVO> getUsers() {
		return users;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
