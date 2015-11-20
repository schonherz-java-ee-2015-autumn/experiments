package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.impl.Log4JLogger;

import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean(name = "communicationBean")
@ViewScoped
public class Communication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// autowired nem működik jsf kell mert a springes nem jó külön futnak
	// az el resolver a springes beameket is felszedi
	@ManagedProperty("#{messageService}")
	private MessageService messageService;

	@ManagedProperty("#{userSessionBean}")
	private UserSession userSession;
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	

	// ezek a mezők rá lesznek bindolva
	private String message;
	private String to;
	
	private List<MessageVO> messages;
	
	public void refresMessages(){
			
		messages = messageService.getMessages(userSession.getCurrentUser());
	}
	
	public void sendMessage() {
		
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		UserVO toUser = null;
		try {
			if((toUser = userService.findUserByName(to))!=null){
				messageService.sendMessage(userService.findUserByName(userSession.getCurrentUser().getUsername()), toUser, message);
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Siker mámor és öröm...");
				currentInstance.addMessage(null, facesMessage);

			}else{
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Can't find user!", "");
				currentInstance.addMessage(null, facesMessage);

			}
		} catch (Exception e) {
			
			
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			currentInstance.addMessage(null, facesMessage);

		}
		
		
	}
	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<MessageVO> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
	}

}
