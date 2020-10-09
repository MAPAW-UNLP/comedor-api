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
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.dto.MealDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.MealService;

@Tag(name = "Meal", description = "API de combo")
@RestController
@RequestMapping("/api/combo")
public class MealRestController extends AbstractRestController<MealDTO>{
	
	@Autowired
	private MealService service;
	
	@Override
	public ResponseEntity<Collection<MealDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(Meal.class));
	}
	@Override
	public ResponseEntity<MealDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(Meal.class, id));
	}
	
	
}
