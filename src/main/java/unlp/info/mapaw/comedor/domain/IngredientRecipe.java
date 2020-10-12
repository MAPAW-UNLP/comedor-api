package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import unlp.info.mapaw.comedor.enums.MeasurementEnum;

@Entity
@Table(name = "INGREDIENT_RECIPE")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_INGREDIENT_RECIPE", allocationSize = 1)
public class IngredientRecipe extends AbstractEntity {

	private String name;

	@Enumerated(EnumType.STRING)
	@Column
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
