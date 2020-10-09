package unlp.info.mapaw.comedor.dto;

import java.util.ArrayList;
import java.util.List;

public class DishRecipeDTO extends AbstractDTO {

	private String name;

	private List<IngredientRecipeDTO> ingredients = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientRecipeDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientRecipeDTO> ingredients) {
		this.ingredients = ingredients;
	}
}
