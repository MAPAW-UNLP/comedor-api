package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.Dish;
import unlp.info.mapaw.comedor.dto.DishDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.DishService;

@Tag(name = "Dish", description = "API de Dish")
@RestController
@RequestMapping("/api/dish")
public class DishRestController extends AbstractRestController<DishDTO>{

	@Autowired
	private DishService service;
	
	@Override
	public ResponseEntity<Collection<DishDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.getAll(Dish.class));
	}

	@Override
	public ResponseEntity<DishDTO> getById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.get(Dish.class,id));
	}

	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping(value = "/save", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<DishDTO> save(@RequestBody DishDTO dto){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(service.save(dto));
	}
}
