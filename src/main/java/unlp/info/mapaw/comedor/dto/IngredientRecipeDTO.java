package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.MeasurementEnum;

public class IngredientRecipeDTO extends AbstractDTO {

	private String name;

	private MeasurementEnum measurement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasurementEnum getMeasurement() {
		return measurement;
	}

	public void setMeasurement(MeasurementEnum measurement) {
		this.measurement = measurement;
	}
}
