package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.TicketTypeEnum;

public class ItemShoppingCartDTO {
	
	private MenuDTO menu;
	
	private TicketTypeEnum ticketType;
	
	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public TicketTypeEnum getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketTypeEnum ticketType) {
		this.ticketType = ticketType;
	}
}
