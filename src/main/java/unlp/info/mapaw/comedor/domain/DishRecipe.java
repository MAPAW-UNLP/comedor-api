package unlp.info.mapaw.comedor.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="DISH_RECIPE")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_DISH_RECIPE", allocationSize = 1)
public class DishRecipe extends AbstractEntity {
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "id_dish_recipe")
	private List<IngredientRecipe> ingredients = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientRecipe> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientRecipe> ingredients) {
		this.ingredients = ingredients;
	}
}
