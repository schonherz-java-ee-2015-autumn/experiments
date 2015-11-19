package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.springframework.data.domain.Sort;

import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean
@ViewScoped
public class MessageBean implements Serializable {

	@ManagedProperty(value = "#{messageService}")
	MessageService messageService;

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	private static final long serialVersionUID = 1L;
	private String message;
	private String sendUser;
	private String targetUser;
	private Date sendDate;
	List<UserVO> users;
	private List<UserVO> selectedUsers;
	FacesMessage fmsg;
	UserVO currentUser;
	List<MessageVO> messages;

	@PostConstruct
	public void init() {
		users = userService.findAll(sortByNameAsc());
		currentUser = currentUser();
		messages = loadMessages();
		selectedUsers = new ArrayList<UserVO>();
	}

	public void sendMessage() {

		System.out.println("current = " + currentUser);

		FacesContext context = FacesContext.getCurrentInstance();
		MessageVO msg = new MessageVO();
		msg.setContent(message);
		msg.setSendDate(getCurrentDate());
		UserVO sender = new UserVO();
		UserVO target = new UserVO();
		sender.setUsername(currentUser.getUsername());
		target.setUsername(selectedUsers.get(0).getUsername());
		msg.setSendUser(sender);
		msg.setTargetUser(target);
		sendDate = new Date();
		msg.setSendDate(sendDate);
		try {
			for (UserVO address : selectedUsers) {
				target.setUsername(address.getUsername());
				messageService.sendMessage(msg);
			}

			fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message sent!", "Success!");
			context.addMessage(null, fmsg);
		} catch (Exception e) {
			fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message not sent!", "Problem occured!");
			context.addMessage(null, fmsg);
		}

	}

	public void onUserDrop(DragDropEvent ddEvent) {
		UserVO userVo = ((UserVO) ddEvent.getData());

		selectedUsers.add(userVo);
		users.remove(userVo);
	}

	public String deleteSelected(UserVO selected) {
		System.out.println("Removed = " + selected);
		selectedUsers.remove(selected);
		users.add(selected);
		return "deleted";

	}

	private Sort sortByNameAsc() {
		return new Sort(Sort.Direction.ASC, "fullname");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendUser() {
		return sendUser;
	}

	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}

	public String getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public void setUsers(List<UserVO> users) {

		this.users = users;

	}

	public List<UserVO> getUsers() {
		return users;
	}

	public List<UserVO> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<UserVO> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public Date getCurrentDate() {
		Date date = new java.util.Date();
		return new Timestamp(date.getTime());

	}

	public UserVO currentUser() {

		FacesContext context = FacesContext.getCurrentInstance();
		return (UserVO) context.getExternalContext().getSessionMap().get("user");

	}

	public List<MessageVO> loadMessages() {

		return messageService.readMessage(currentUser.getId());

	}

	public void logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public List<MessageVO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
	}

}
