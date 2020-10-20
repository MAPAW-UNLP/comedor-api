package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Dish;
import unlp.info.mapaw.comedor.domain.DishRecipe;
import unlp.info.mapaw.comedor.dto.DishDTO;
import unlp.info.mapaw.comedor.dto.IngredientDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;

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
	
	@Override
	protected void validateDTO(DishDTO dto) {
		if (dto.getRecipe() == null)
			throw new ServiceException("Dish Recipe is required");
		if (dto.getType() == null)
			throw new ServiceException("Type is required");
		if (dto.getName() == null)
			throw new ServiceException("Name is required");
	}

}
