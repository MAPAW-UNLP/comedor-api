package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.MeasurementEnum;

public class IngredientDTO extends AbstractDTO {

    private String name;
	
    private MeasurementEnum measurement;
	
	private int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
