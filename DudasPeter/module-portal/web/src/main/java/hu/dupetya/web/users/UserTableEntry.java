package hu.dupetya.web.users;

public class UserTableEntry {
	private String name;
	private String email;
	private String dob;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String user) {
		name = user;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
