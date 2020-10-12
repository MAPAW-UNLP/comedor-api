package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import unlp.info.mapaw.comedor.enums.DishTypeEnum;

@Entity
@Table(name = "DISH", schema="public")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_DISH", allocationSize = 1)
public class Dish extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_dish_recipe")
	private DishRecipe recipe;

	@Enumerated(EnumType.STRING)
	@Column
	private DishTypeEnum type;

	public DishRecipe getRecipe() {
		return recipe;
	}

	public void setRecipe(DishRecipe recipe) {
		this.recipe = recipe;
	}
}
