package unlp.info.mapaw.comedor.dto;

import java.math.BigDecimal;

import unlp.info.mapaw.comedor.enums.MeasurementEnum;

public class IngredientReportDTO {

	private String name;
	
	private BigDecimal quantity;
	
	private MeasurementEnum measurement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public MeasurementEnum getMeasurement() {
		return measurement;
	}

	public void setMeasurement(MeasurementEnum measurement) {
		this.measurement = measurement;
	}
}
