package cl.exql.sp.model;

import java.io.Serializable;

public class Users implements Serializable {
	
	private static final long serialVersionUID = -7308240870138032719L;
	
	// private Long id;
	private String email;
	private String password;
	private Role role;

	public Users() {
	}

	public Users(String email, String password, Role role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", role=" + role + "]";
	}

}
