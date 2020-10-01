package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.TicketTypeEnum;

public class TicketDTO extends AbstractDTO {
	
	private MenuDTO menu;

	private UserDTO client;
	
	private TicketTypeEnum type;

	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public UserDTO getClient() {
		return client;
	}

	public void setClient(UserDTO client) {
		this.client = client;
	}

	public TicketTypeEnum getType() {
		return type;
	}

	public void setType(TicketTypeEnum type) {
		this.type = type;
	}

}
