package unlp.info.mapaw.comedor.dto;

public class DishDTO extends AbstractDTO {

	private String name;

	private DishRecipeDTO recipe;
	
	// set de Description to DishTypeEnum
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DishRecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(DishRecipeDTO recipe) {
		this.recipe = recipe;
	}
}
