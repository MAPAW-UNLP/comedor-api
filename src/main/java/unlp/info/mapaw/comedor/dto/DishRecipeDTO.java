package unlp.info.mapaw.comedor.dto;

import java.util.ArrayList;
import java.util.List;

public class DishRecipeDTO extends AbstractDTO {

	private String name;

	private List<IngredientDTO> ingredients = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}
}
