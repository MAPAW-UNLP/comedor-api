package unlp.info.mapaw.comedor.repository;

import java.util.Date;

import unlp.info.mapaw.comedor.domain.Ticket;

public interface ITicketRepository {
	
	Ticket getByDate(Date date);

}
