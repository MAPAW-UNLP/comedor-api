package unlp.info.mapaw.comedor.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ComedorRestController {
	
	@GetMapping("/home")
	public String home() {
		return "Welcome home!";
	}
	
	@GetMapping("/restricted")  
	@ResponseBody  
	public String restricted() {  
	    return "You found the secret lair!";  
	}

}
