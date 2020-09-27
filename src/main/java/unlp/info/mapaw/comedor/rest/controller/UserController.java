package unlp.info.mapaw.comedor.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unlp.info.mapaw.comedor.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

//	//@Secured("ROLE_ADMIN")
//	@PreAuthorize("hasRole('ROLE_client')")
//	//@PreAuthorize("hasRole('isAuthenticated()')")
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUser(@PathVariable long id) {
//		final User user = userService.getUser(id);
//
//		if (user == null) {
//			return ResponseEntity.notFound().build();
//		}
//
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
}
