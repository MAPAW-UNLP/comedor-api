package unlp.info.mapaw.comedor.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ComedorRestController {
	
	@GetMapping("/home")
	public String home() {
		return "Welcome home!";
	}
	
	@PreAuthorize("isAuthenticated()")  
	@GetMapping("/restricted")  
	@ResponseBody  
	public String restricted() {  
	    return "You found the secret lair!";  
	}

}
