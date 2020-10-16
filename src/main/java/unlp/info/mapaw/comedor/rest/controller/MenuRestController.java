package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.dto.CreateMenusDTO;
import unlp.info.mapaw.comedor.dto.MenuDTO;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.MenuService;

@Tag(name = "Menu", description = "API de menu")
@RestController
@RequestMapping("/api/menu")
public class MenuRestController extends AbstractRestController<MenuDTO>{

	@Autowired 
	private MenuService service;
	
	public ResponseEntity<Collection<MenuDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(Menu.class));
	}
	
	@Override
	public ResponseEntity<MenuDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(Menu.class, id));
	}
	
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PostMapping(value="/search", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Collection<MenuDTO>> getBySearch(@RequestBody MenuSearchDTO search){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getBySearch(search));
	}
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@PostMapping(value="/create", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Collection<MenuDTO>> create(@RequestBody CreateMenusDTO createMenusDTO){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.createFrom(createMenusDTO));
	}

	//Se comenta porque la generacion de Menu es atravez de otro DTO (Debe recibir MealDTO, List<Date> fechas, y List<KitchenSite> sedes)
//	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
//	@PreAuthorize("hasRole('EMPLOYEE')")
//	@PutMapping(value="/save", consumes = { "application/json" }, produces = { "application/json" })
//	public ResponseEntity<MenuDTO> save( @RequestBody MenuDTO dto) {
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
//		        .body(service.save(dto));
//	}
	
//	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
//	@PreAuthorize("hasRole('EMPLOYEE')")
//	@PutMapping(value="/create", consumes = { "application/json" }, produces = { "application/json" })
//	public ResponseEntity<MenuDTO> create( @RequestBody MenuDTO dto) {
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
//		        .body(service.save(dto));
//	}
}
