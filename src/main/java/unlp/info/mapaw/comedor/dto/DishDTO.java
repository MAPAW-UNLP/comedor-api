package unlp.info.mapaw.comedor.dto;

import java.util.ArrayList;
import java.util.List;

import unlp.info.mapaw.comedor.enums.DishTypeEnum;

public class DishDTO extends AbstractDTO {

	private String name;

	private List<IngredientDTO> ingredients = new ArrayList<>();
	
	private DishTypeEnum type;

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

	public DishTypeEnum getType() {
		return type;
	}

	public void setType(DishTypeEnum type) {
		this.type = type;
	}
}
