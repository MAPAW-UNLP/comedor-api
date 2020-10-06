package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.DishRecipe;
import unlp.info.mapaw.comedor.domain.IngredientRecipe;
import unlp.info.mapaw.comedor.dto.DishRecipeDTO;

@Service
public class DishRecipeService extends AbstractEntityService<DishRecipeDTO, DishRecipe> {
	
	@Autowired
	private IngredientRecipeService ingredientService;
	

	@Override
	protected DishRecipeDTO addCustomPropertiesToDTO(DishRecipe entity, DishRecipeDTO dto) {
		dto.setName(entity.getName());
		for (IngredientRecipe ingredient : entity.getIngredients()) {
			dto.getIngredients().add(ingredientService.createDTO(ingredient));
		}
		return dto;
	}

	@Override
	protected DishRecipeDTO createEmptyDTO() {
		return new DishRecipeDTO();
	}	
}
