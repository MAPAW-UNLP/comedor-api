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
import unlp.info.mapaw.comedor.domain.Ejemplo;
import unlp.info.mapaw.comedor.dto.EjemploDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.EjemploService;


@Tag(name = "Ejemplo", description = "API de Ejemplo")
@RestController
@RequestMapping("/api/ejemplo")
public class EjemploRestController extends AbstractRestController<EjemploDTO> {

	@Autowired
	private EjemploService service;
	
	@Override
	public ResponseEntity<Collection<EjemploDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(Ejemplo.class));
	}

	@Override
	public ResponseEntity<EjemploDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(Ejemplo.class, id));
	}

	
}
