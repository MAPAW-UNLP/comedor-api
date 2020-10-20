package unlp.info.mapaw.comedor.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.repository.ITicketRepository;

@Repository
public class TicketRepository implements ITicketRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ticket getByDate(Date date) {
		Query query = entityManager.createQuery(
				"select o from Ticket o where year(o.menu.date) = year(:fecha) and month(o.menu.date) = month(:fecha) and day(o.menu.date) = day(:fecha)",
				Ticket.class);
		query.setParameter("fecha", date);
		List<Ticket> tickets = query.getResultList();
		if (tickets.isEmpty())
			return null;
		return tickets.get(0);
	}

	@Override
	public List<Ticket> getPendings() {
		Query query = entityManager.createQuery("select o from Ticket o where o.consumed = false", Ticket.class);
		return query.getResultList();
	}

}
