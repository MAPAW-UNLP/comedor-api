package unlp.info.mapaw.comedor.dto;

import java.util.ArrayList;
import java.util.List;

public class MenusReportDTO {

	private List<MealReportDTO> meals = new ArrayList<MealReportDTO>();

	private List<IngredientReportDTO> ingredients = new ArrayList<IngredientReportDTO>();

	public List<MealReportDTO> getMeals() {
		return meals;
	}

	public void setMeals(List<MealReportDTO> meals) {
		this.meals = meals;
	}

	public List<IngredientReportDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientReportDTO> ingredients) {
		this.ingredients = ingredients;
	}

}
