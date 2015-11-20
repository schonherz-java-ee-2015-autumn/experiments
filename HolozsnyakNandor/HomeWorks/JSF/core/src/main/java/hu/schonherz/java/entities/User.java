package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="User.getAllUsersFromTable", query = "SELECT u FROM User u")
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false,unique=true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String fullname;
	@Column(unique=true)
	private String email;
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
