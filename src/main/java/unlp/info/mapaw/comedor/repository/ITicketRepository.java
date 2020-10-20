package unlp.info.mapaw.comedor.repository;

import java.util.Date;
import java.util.List;

import unlp.info.mapaw.comedor.domain.Ticket;

public interface ITicketRepository {
	
	Ticket getByDate(Date date);
	
	List<Ticket> getPendings();

}
