package unlp.info.mapaw.comedor.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import unlp.info.mapaw.comedor.enums.RoleEnum;

public class SecuredUser extends User {

	public SecuredUser(String username, String password, Collection<? extends GrantedAuthority> authorities, unlp.info.mapaw.comedor.domain.User user) {
		super(username, password, authorities);
		this.user = user;
	}

	public unlp.info.mapaw.comedor.domain.User getUser() {
		return user;
	}

	public void setUser(unlp.info.mapaw.comedor.domain.User user) {
		this.user = user;
	}

	private static final long serialVersionUID = -206903133534213495L;
	
	private unlp.info.mapaw.comedor.domain.User user;
	
	public boolean isClient() {
		return this.getUser().getRole() != null && this.getUser().getRole().equals(RoleEnum.CLIENT);
	}
	
	public boolean isEmployee() {
		return this.getUser().getRole() != null && this.getUser().getRole().equals(RoleEnum.EMPLOYEE);
	}

}
