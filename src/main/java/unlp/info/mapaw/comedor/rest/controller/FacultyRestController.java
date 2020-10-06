package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.Faculty;
import unlp.info.mapaw.comedor.dto.FacultyDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.FacultyService;

@Tag(name = "Faculty", description = "API de Faculty")
@RestController
@RequestMapping("/api/faculty")
public class FacultyRestController extends AbstractRestController<FacultyDTO> {

	@Autowired
	private FacultyService service;
	
	@Override
	public ResponseEntity<Collection<FacultyDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(Faculty.class));
	}

	@Override
	public ResponseEntity<FacultyDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(Faculty.class, id));
	}
	
}
