package unlp.info.mapaw.comedor.enums;

public enum UserConditionEnum {

	DOCENTE("Docente"), ESTUDIANTE("Estudiando"), NO_DOCENTE("No Docente");
	
	private String description;
	
	UserConditionEnum(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
