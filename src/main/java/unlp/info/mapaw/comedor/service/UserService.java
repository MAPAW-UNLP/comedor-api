package unlp.info.mapaw.comedor.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.repository.UserRepository;
import unlp.info.mapaw.comedor.security.SecuredUser;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public SecuredUser loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User retrievedUser = userRepository.findByUsername(userName);
		if (retrievedUser == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		final SecuredUser securedUser = this.createDTOFormEntity(retrievedUser);
		return securedUser;
	}

	public SecuredUser getById(long id) {
		final User retrievedUser = userRepository.findById(id);
		final SecuredUser securedUser = this.createDTOFormEntity(retrievedUser);
		return securedUser;
	}

	public User getUser(long id) {
		return userRepository.findById(id);
	}
	
	private SecuredUser createDTOFormEntity(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		SecuredUser securedUser = new SecuredUser(user.getUsername(), user.getPassword(), authorities, user);
		return securedUser;
	}
}
