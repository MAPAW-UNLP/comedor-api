package unlp.info.mapaw.comedor.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.repository.ITicketRepository;

@Repository
public class TicketRepository implements ITicketRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ticket getByDateAndUser(Date date, User user) {
		Query query = entityManager.createQuery(
				"select o from Ticket o where o.client.id = :userId and year(cast(o.menu.date as date)) = year(cast(:fecha as date)) and month(cast(o.menu.date as date)) = month(cast(:fecha as date)) and day(cast(o.menu.date as date)) = day(cast(:fecha as date))",
				Ticket.class);
		query.setParameter("fecha", date);
		query.setParameter("userId", user.getId());
		List<Ticket> tickets = query.getResultList();
		if (tickets.isEmpty())
			return null;
		return tickets.get(0);
	}

	@Override
	public List<Ticket> getPendings(User user) {
		String queryString = "select o from Ticket o where o.consumed = false ";
		if (user != null)
			queryString = queryString + "and o.client.id = :userId";
		Query query = entityManager.createQuery(queryString, Ticket.class);
		if (user != null)
			query.setParameter("userId", user.getId());
		return query.getResultList();
	}

}
