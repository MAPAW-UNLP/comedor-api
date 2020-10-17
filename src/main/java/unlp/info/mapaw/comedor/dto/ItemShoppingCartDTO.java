package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.TicketTypeEnum;

public class ItemShoppingCartDTO {
	
	private MenuDTO menuDTO;
	
	private TicketTypeEnum ticketType;
	
	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public TicketTypeEnum getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketTypeEnum ticketType) {
		this.ticketType = ticketType;
	}
}
