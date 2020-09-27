package unlp.info.mapaw.comedor.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.dto.UserDTO;
import unlp.info.mapaw.comedor.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User retrievedUser = userRepository.findByUsername(userName);
		if (retrievedUser == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		final UserDTO dto = this.createDTOFormEntity(retrievedUser);
		return dto;
	}

	public UserDTO getById(long id) {
		final User retrievedUser = userRepository.findById(id);
		final UserDTO dto = this.createDTOFormEntity(retrievedUser);
		return dto;
	}

	public User getUser(long id) {
		return userRepository.findById(id);
	}
	
	private UserDTO createDTOFormEntity(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		UserDTO dto = new UserDTO(user.getId(), user.getUsername(), user.getFullname(),
				user.getDni(), user.getPassword(), user.getRole().name(), authorities);
		return dto;
	}
}
