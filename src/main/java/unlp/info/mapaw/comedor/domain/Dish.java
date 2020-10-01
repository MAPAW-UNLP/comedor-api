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
@Table(name ="DISH")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_DISH", allocationSize = 1)
public class Dish extends AbstractEntity {
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "id_dish")
	private List<Ingredient> ingredients = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
