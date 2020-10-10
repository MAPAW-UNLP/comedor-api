package unlp.info.mapaw.comedor.dto;

public class IngredientDTO extends AbstractDTO {

	private IngredientRecipeDTO recipe;
	
	private int quantity;


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public IngredientRecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(IngredientRecipeDTO recipe) {
		this.recipe = recipe;
	}
}
