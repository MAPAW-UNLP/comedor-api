package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import unlp.info.mapaw.comedor.enums.RoleEnum;

@Entity
public class User extends AbstractEntity {
	
	private static final long serialVersionUID = -6908007954662757425L;
	@Column
	private String username;
	
	@Column
	private String fullname;

	@Column
	private String password;
	
	@Column
	private String dni;

	@Enumerated(EnumType.STRING)
	@Column
	private RoleEnum role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

}
