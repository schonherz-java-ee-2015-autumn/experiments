package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String username;
	private String password;
	
	@ManyToMany
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
		super();
	}

}
