package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	//private String sendUser;
	private String targetUser;
	private Date sendDate;

	public void sendMessage() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		MessageVO msg = new MessageVO();
		msg.setContent(message);
		msg.setSendDate(sendDate);
		UserVO sender = new UserVO();
		UserVO target = new UserVO();
		sender.setUsername(AuthBean.getUser());
		target.setUsername(targetUser);
		msg.setSendUser(sender);
		msg.setTargetUser(target);
		sendDate = new Date();
		msg.setSendDate(sendDate);
		try {
			messageService.sendMessage(msg);
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres üzenetküldés", "Sikeres!");
			context.addMessage(null, fmsg);
		} catch (Exception e) {

			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba az üzenet elküldése közben!",
					"Hiba!");
			context.addMessage(null, fmsg);
			e.printStackTrace();
		}

	}

	public List<String> searchUser(String query) {
		List<UserVO> list = userService.findUsersContaining(query);
		List<String> users = new ArrayList<String>();
		for (UserVO item : list) {
			users.add(item.getUsername());
		}
		return users;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public String getSendUser() {
//		return sendUser;
//	}
//
//	public void setSendUser(String sendUser) {
//		this.sendUser = sendUser;
//	}

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

}
