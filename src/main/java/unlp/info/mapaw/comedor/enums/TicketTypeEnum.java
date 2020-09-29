package unlp.info.mapaw.comedor.enums;

public enum TicketTypeEnum {

	ON_SITE("on site"), TAKEAWAY("takeaway");
	
	private String description;
	
	TicketTypeEnum(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
