package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;

	@ManyToMany
	List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
