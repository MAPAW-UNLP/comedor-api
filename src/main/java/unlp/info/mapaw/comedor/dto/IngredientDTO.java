package unlp.info.mapaw.comedor.dto;

import java.math.BigDecimal;

public class IngredientDTO extends AbstractDTO {

	private IngredientRecipeDTO recipe;
	
	private BigDecimal quantity;


	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public IngredientRecipeDTO getRecipe() {
		return recipe;
	}

	public void setRecipe(IngredientRecipeDTO recipe) {
		this.recipe = recipe;
	}
}
