package unlp.info.mapaw.comedor.enums;

public enum DishTypeEnum {

	ENTRADA("Entrada"), PLATO_PRINCPAL("Plato Principal"), GUARNICION("Guarnición"), POSTRE("Postre"), BEBIDA("Bebida");

	private String description;

	DishTypeEnum(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
