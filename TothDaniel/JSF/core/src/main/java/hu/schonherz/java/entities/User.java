package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String personFirstName;
	private String personLastName;
	private String phone;
	private String email;

	@Lob
	private byte[] image;

	@ManyToMany
	private List<Role> roles;

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

	public User() {
		super();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
