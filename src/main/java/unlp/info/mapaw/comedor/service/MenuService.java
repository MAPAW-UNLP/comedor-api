package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.dto.MenuDTO;


@Service
public class MenuService extends AbstractEntityService<MenuDTO,Menu>{

	@Autowired
	private KitchenSiteService kitchenService;
	
	@Autowired
	private MealService mealService;
	
	@Override
	protected MenuDTO addCustomPropertiesToDTO(Menu entity, MenuDTO dto) {
		dto.setName(entity.getName());
		dto.setCurrentStock(entity.getCurrentStock());
		dto.setDate(entity.getDate());
		dto.setKitchenSite(kitchenService.createDTO(entity.getKitchenSite()));
		dto.setMeal(mealService.createDTO(entity.getMeal()));
		return dto;
	}
	
	@Override
	protected MenuDTO createEmptyDTO() {
		return new MenuDTO();
	}

	@Override
	protected Menu addCustomPropertiesToEntity(MenuDTO dto, Menu entity) {
		entity.setCurrentStock(dto.getCurrentStock());
		entity.setDate(dto.getDate());
		entity.setName(dto.getName());
		entity.setUnitPrice(dto.getUnitPrice());
		entity.setKitchenSite(this.crudService.findOne(KitchenSite.class, dto.getKitchenSite().getId()));
		entity.setMeal(this.crudService.findOne(Meal.class, dto.getMeal().getId()));
		return entity;
	}

	@Override
	protected Menu createEmptyEntity() {
		return new Menu();
	}
	
}
