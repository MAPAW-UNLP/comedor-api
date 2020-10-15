package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Dish;
import unlp.info.mapaw.comedor.domain.DishRecipe;
import unlp.info.mapaw.comedor.dto.DishDTO;

@Service
public class DishService extends AbstractEntityService<DishDTO,Dish>{

	@Autowired
	DishRecipeService dishRecepiService;
	
	@Override
	protected DishDTO addCustomPropertiesToDTO(Dish entity, DishDTO dto) {
		dto.setName(dishRecepiService.createDTO(entity.getRecipe()).getName());
		dto.setRecipe(dishRecepiService.createDTO(entity.getRecipe()));
		dto.setType(entity.getType());
		return dto;
	}

	@Override
	protected Dish addCustomPropertiesToEntity(DishDTO dto, Dish entity) {
		entity.setRecipe(this.crudService.findOne(DishRecipe.class, dto.getRecipe().getId()));
		entity.setType(dto.getType());
		return entity;
	}

	@Override
	protected DishDTO createEmptyDTO() {
		return new DishDTO();
	}

	@Override
	protected Dish createEmptyEntity() {
		return new Dish();
	}

}
