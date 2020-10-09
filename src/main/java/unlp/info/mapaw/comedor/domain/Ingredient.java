package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import unlp.info.mapaw.comedor.enums.MeasurementEnum;

@Entity
@Table(name = "INGREDIENT")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_INGREDIENT", allocationSize = 1)
public class Ingredient extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_ingredient_recipe")
	private IngredientRecipe recipe;

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public IngredientRecipe getRecipe() {
		return recipe;
	}

	public void setRecipe(IngredientRecipe recipe) {
		this.recipe = recipe;
	}

}
