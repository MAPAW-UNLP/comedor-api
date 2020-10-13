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

import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.DishRecipe;
import unlp.info.mapaw.comedor.dto.DishRecipeDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.DishRecipeService;

@Tag(name = "Dish Recipe", description = "API de Dish Recipe")
@RestController
@RequestMapping("/api/dishRecipe")
public class DichRecipeRestController extends AbstractRestController<DishRecipeDTO> {

	@Autowired
	private DishRecipeService service;

	@Override
	public ResponseEntity<Collection<DishRecipeDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.getAll(DishRecipe.class));
	}

	@Override
	public ResponseEntity<DishRecipeDTO> getById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.get(DishRecipe.class, id));
	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping(value = "/save", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<DishRecipeDTO> save(@RequestBody DishRecipeDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(service.save(dto));
	}
}
