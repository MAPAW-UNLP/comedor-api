package unlp.info.mapaw.comedor.repository;

import java.util.Date;
import java.util.List;

import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.domain.User;

public interface ITicketRepository {
	
	Ticket getByDateAndUser(Date date, User user);
	
	List<Ticket> getPendings(User user);
	
	Ticket getTicketByNumber(String ticketNumber);
	
	List<Ticket> getByKitchenSiteAndDate(long idKitchenSite, Date date);

}
