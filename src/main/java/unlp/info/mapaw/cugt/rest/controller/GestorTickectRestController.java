package unlp.info.mapaw.cugt.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class GestorTickectRestController {

	@GetMapping
	public String getStatus() {
		return "OK";
	}
}
