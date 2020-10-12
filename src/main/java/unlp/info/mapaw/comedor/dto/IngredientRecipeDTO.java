package unlp.info.mapaw.comedor.dto;

public class IngredientRecipeDTO extends AbstractDTO {

	private String name;

	private String measurement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
}
