package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.dto.MenuDTO;
import unlp.info.mapaw.comedor.repository.KitchenSiteRepository;
import unlp.info.mapaw.comedor.repository.MealRepository;
import unlp.info.mapaw.comedor.repository.MenuRepository;
import unlp.info.mapaw.comedor.rest.controller.RequestModel.MenuRequestModel;
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
	
	@Autowired
	private MenuRepository repo;
	
	@Autowired
	private KitchenSiteRepository repoKitchen;
	
	@Autowired 
	private MealRepository repoMeal;
	
	@PostMapping(value = "/", consumes = { "application/json" })
	public MenuDTO createMenu(@RequestBody MenuRequestModel requestDetails) {
		
        MenuDTO menuDto = new MenuDTO();
        menuDto.setCurrentStock(requestDetails.getCurrentStock());
        menuDto.setDate(requestDetails.getDate());
        menuDto.setName(requestDetails.getName());
        menuDto.setUnitPrice(requestDetails.getUnitPrice());

        KitchenSite kitchenSite = repoKitchen.findById(requestDetails.getKitchenSiteID()).get();
        Meal meal = repoMeal.findById(requestDetails.getMealID()).get();
        
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        
        menu.setMeal(meal);
        menu.setKitchenSite(kitchenSite);
        
        repo.save(menu);
        return menuDto;
	}
	
}
