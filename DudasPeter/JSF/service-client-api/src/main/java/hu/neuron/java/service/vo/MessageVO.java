package hu.neuron.java.service.vo;

import java.io.Serializable;
import java.util.Date;

public class MessageVO implements Serializable {

	private static final long serialVersionUID = 5932000328505763772L;

	private Long id;

	private Date sendDate;

	private UserVO sendUser;

	private UserVO targetUser;
	
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public UserVO getSendUser() {
		return sendUser;
	}

	public void setSendUser(UserVO sendUser) {
		this.sendUser = sendUser;
	}

	public UserVO getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(UserVO targetUser) {
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", sendDate=" + sendDate + ", sendUser=" + sendUser + ", targetUser="
				+ targetUser + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
