package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.dto.TicketDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;

@Service
public class TicketService extends AbstractEntityService<TicketDTO, Ticket> {
	
	@Override
	protected TicketDTO addCustomPropertiesToDTO(Ticket entity, TicketDTO dto) {
		dto.setType(entity.getType());
		//menu falta lo otro para hacerlo
		return dto;
	}

	//no se usa
	@Override
	protected Ticket addCustomPropertiesToEntity(TicketDTO dto, Ticket entity) {
		return entity;
	}

	@Override
	protected TicketDTO createEmptyDTO() {
		return new TicketDTO();
	}

	@Override
	protected Ticket createEmptyEntity() {
		return new Ticket();
	}
	
	public synchronized TicketDTO buy(TicketDTO dto) {
		Ticket entity = this.createEntityFromDTO(dto);
		if (!this.menuHasStock(entity.getMenu()))
			throw new ServiceException("Menu has no more stock");
		
		//Descontar en Menu el stock

		entity.setClient(this.getUsuarioLogueado().getUser());
		entity = crudService.save(entity);
		return this.createDTO(entity);
	}

	private boolean menuHasStock(Menu menu) {
		return menu.getCurrentStock() > 0;
	}

}
