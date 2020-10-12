package unlp.info.mapaw.comedor.enums;

public enum MeasurementEnum {

	unit("unit"), kg("kilogram"), g("gram"), mg("milligram"), l("litre"), ml("millilitre"), cm3("cubic centimetre"),
	ml3("cubic millimetre");

	private String description;

	MeasurementEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static MeasurementEnum getEnum(String description) {
		for (MeasurementEnum me : MeasurementEnum.values()) {
			if (me.getDescription().equals(description))
				return me;
		}
		return null;
	}

}
