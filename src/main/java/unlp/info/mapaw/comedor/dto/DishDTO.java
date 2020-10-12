package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.DishTypeEnum;

public class DishDTO extends AbstractDTO {

	private String name;

	private DishRecipeDTO recipe;
	
	private DishTypeEnum type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DishTypeEnum getType() {
		return type;
	}

	public void setType(DishTypeEnum type) {
		this.type = type;
	}

	public DishRecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(DishRecipeDTO recipe) {
		this.recipe = recipe;
	}
}
