package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.IngredientRecipe;
import unlp.info.mapaw.comedor.dto.DishRecipeDTO;
import unlp.info.mapaw.comedor.dto.IngredientRecipeDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;

@Service
public class IngredientRecipeService extends AbstractEntityService<IngredientRecipeDTO, IngredientRecipe> {

	@Override
	protected IngredientRecipeDTO addCustomPropertiesToDTO(IngredientRecipe entity, IngredientRecipeDTO dto) {
		dto.setName(entity.getName());
		dto.setMeasurement(entity.getMeasurement());
		return dto;
	}

	@Override
	protected IngredientRecipeDTO createEmptyDTO() {
		return new IngredientRecipeDTO();
	}

	@Override
	protected IngredientRecipe addCustomPropertiesToEntity(IngredientRecipeDTO dto, IngredientRecipe entity) {
		entity.setMeasurement(dto.getMeasurement());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	protected IngredientRecipe createEmptyEntity() {
		return new IngredientRecipe();
	}
	
	@Override
	protected void validateDTO(IngredientRecipeDTO dto) {
		if (dto.getName() == null)
			throw new ServiceException("Name is required");
		if (dto.getMeasurement() == null)
			throw new ServiceException("Measurement is required");
	}

}
