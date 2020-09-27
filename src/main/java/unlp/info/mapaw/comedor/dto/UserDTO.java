package unlp.info.mapaw.comedor.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO extends User {

	private static final long serialVersionUID = -2523560900681054097L;

	public UserDTO(long id, String username, String fullName, String dni, String password, String role,  Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
		this.role = role;
		this.dni = dni;
		this.fullName = fullName;
		
	}
	private long id;
	
	private String dni;
	
	private String fullName;

	private String role;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
