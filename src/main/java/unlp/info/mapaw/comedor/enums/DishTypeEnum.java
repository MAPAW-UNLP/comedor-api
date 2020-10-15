package unlp.info.mapaw.comedor.enums;

public enum DishTypeEnum {

	ENTRADA("appetizer"), PLATO_PRINCIPAL("main dish"), GUARNICION("side dish"), POSTRE("dessert"), BEBIDA("drink");

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
	
	public static DishTypeEnum getEnum(String description) {
		for (DishTypeEnum dt : DishTypeEnum.values()) {
			if (dt.getDescription().equals(description))
				return dt;
		}
		return null;
	}
}
