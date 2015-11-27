package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Message.findMessages", query = "select m from Message m where (m.sendUser.id = :from and m.targetUser.id = :to ) or (m.sendUser.id = :to and m.targetUser.id = :from) order by m.sendDate") })

public class Message extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;

	@OneToOne
	private User sendUser;

	@OneToOne
	private User targetUser;
	
	
	@PrePersist
	  void createdAt() {
	    this.sendDate = new Date();
	  }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

}
