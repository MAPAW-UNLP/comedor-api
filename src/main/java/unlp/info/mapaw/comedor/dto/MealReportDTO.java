package unlp.info.mapaw.comedor.dto;

import java.util.List;

public class MealReportDTO {

	private String name;
	
	private int cantSales;
	
	private List<IngredientReportDTO> ingredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantSales() {
		return cantSales;
	}

	public void setCantSales(int cantSales) {
		this.cantSales = cantSales;
	}

	public List<IngredientReportDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientReportDTO> ingredients) {
		this.ingredients = ingredients;
	}
}
