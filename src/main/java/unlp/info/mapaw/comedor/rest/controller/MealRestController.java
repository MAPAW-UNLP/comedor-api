package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.dto.MealDTO;
import unlp.info.mapaw.comedor.dto.MealEvaluationDTO;
import unlp.info.mapaw.comedor.dto.MealEvaluationRequestDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.MealEvaluationService;
import unlp.info.mapaw.comedor.service.MealService;

@Tag(name = "Meal", description = "API de combo")
@RestController
@RequestMapping("/api/meal")
public class MealRestController extends AbstractRestController<MealDTO>{
	
	@Autowired
	private MealService service;
	
	@Autowired
	private MealEvaluationService evaluationService;
	
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
	
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping(value="/save", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<MealDTO> save ( @RequestBody MealDTO dto){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.save(dto));
	}
	
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping(value="/{id}/evaluation/", produces = { "application/json" })
	public ResponseEntity<Collection<MealEvaluationDTO>> getEvaluation(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(evaluationService.getEvaluationsFromMeal(id));
	}
	
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PreAuthorize("hasRole('CLIENT')")
	@PutMapping(value="/evaluate", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<MealEvaluationDTO> evaluate(@RequestBody MealEvaluationRequestDTO dto){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(evaluationService.evaluate(dto));
	}
}
