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
import unlp.info.mapaw.comedor.domain.IngredientRecipe;
import unlp.info.mapaw.comedor.dto.IngredientRecipeDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.IngredientRecipeService;

@Tag(name = "Ingredient Recipe", description = "API de Ingredient Recipe")
@RestController
@RequestMapping("/api/ingredientRecipe")
public class IngredientRecipeRestController extends AbstractRestController<IngredientRecipeDTO> {

	@Autowired
	private IngredientRecipeService service;
	
	@Override
	public ResponseEntity<Collection<IngredientRecipeDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(IngredientRecipe.class));
	}

	@Override
	public ResponseEntity<IngredientRecipeDTO> getById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(IngredientRecipe.class, id));
	}
	
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping(value="/save", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<IngredientRecipeDTO> save( @RequestBody IngredientRecipeDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.save(dto));
	}

}
