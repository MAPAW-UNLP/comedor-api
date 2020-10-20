package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Ingredient;
import unlp.info.mapaw.comedor.domain.IngredientRecipe;
import unlp.info.mapaw.comedor.dto.IngredientDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;

@Service
public class IngredientService extends AbstractEntityService<IngredientDTO, Ingredient> {

	@Autowired
	private IngredientRecipeService recipeService;

	@Override
	protected IngredientDTO addCustomPropertiesToDTO(Ingredient entity, IngredientDTO dto) {
		dto.setQuantity(entity.getQuantity());
		dto.setRecipe(recipeService.createDTO(entity.getRecipe()));
		return dto;
	}

	@Override
	protected Ingredient addCustomPropertiesToEntity(IngredientDTO dto, Ingredient entity) {
		entity.setQuantity(dto.getQuantity());
		entity.setRecipe(this.crudService.findOne(IngredientRecipe.class, dto.getRecipe().getId()));
		return entity;
	}

	@Override
	protected IngredientDTO createEmptyDTO() {
		return new IngredientDTO();
	}

	@Override
	protected Ingredient createEmptyEntity() {
		return new Ingredient();
	}

	@Override
	protected void validateDTO(IngredientDTO dto) {
		if (dto.getRecipe() == null)
			throw new ServiceException("Ingredient Recipe is required");
		if (dto.getQuantity() == null)
			throw new ServiceException("Quantity is required");
	}

}
