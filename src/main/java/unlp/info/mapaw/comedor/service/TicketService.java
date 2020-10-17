package unlp.info.mapaw.comedor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.dto.ItemShoppingCartDTO;
import unlp.info.mapaw.comedor.dto.ShoppingCartDTO;
import unlp.info.mapaw.comedor.dto.TicketDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;
import unlp.info.mapaw.comedor.utils.RandomString;

@Service
public class TicketService extends AbstractEntityService<TicketDTO, Ticket> {
	
	@Autowired
	private MenuService menuService;

	@Override
	protected TicketDTO addCustomPropertiesToDTO(Ticket entity, TicketDTO dto) {
		dto.setType(entity.getType());
		dto.setMenu(menuService.createDTO(entity.getMenu()));
		dto.setType(entity.getType());
		dto.setNumber(entity.getNumber());
		return dto;
	}

	// no se usa
	@Override
	protected Ticket addCustomPropertiesToEntity(TicketDTO dto, Ticket entity) {
		throw new ServiceException("Not Supported");
		//return entity;
	}

	@Override
	protected TicketDTO createEmptyDTO() {
		return new TicketDTO();
	}

	@Override
	protected Ticket createEmptyEntity() {
		return new Ticket();
	}

	public synchronized List<TicketDTO> buy(ShoppingCartDTO shoppingCartDTO) {
		List<TicketDTO> ticketsDTO = new ArrayList<>();
		if (!shoppingCartDTO.getItems().isEmpty()) {
			List<Ticket> tickets = new ArrayList<>();
			for (ItemShoppingCartDTO item : shoppingCartDTO.getItems()) {
				Menu menu = crudService.findOne(Menu.class, item.getMenuDTO().getId());
				if (!this.menuHasStock(menu))
					throw new ServiceException("Menu has no more stock");
				menu.discountStock();
				// menu = crudService.save(menu);
				Ticket ticket = new Ticket();
				ticket.setClient(this.getUsuarioLogueado().getUser());
				ticket.setMenu(menu);
				ticket.setType(item.getTicketType());
				tickets.add(ticket);
			}

			for (Ticket ticket : tickets) {
				ticket.setNumber(RandomString.getAlphaNumericString(10));
				Ticket t = crudService.save(ticket);
				ticketsDTO.add(this.createDTO(t));
			}
			return ticketsDTO;
		} else {
			throw new ServiceException("No items for buys");
		}

	}

	private boolean menuHasStock(Menu menu) {
		return menu.getCurrentStock() > 0;
	}

}
