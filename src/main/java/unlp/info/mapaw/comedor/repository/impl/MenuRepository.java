package unlp.info.mapaw.comedor.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;
import unlp.info.mapaw.comedor.repository.IMenuRepositoy;

@Repository
public class MenuRepository implements IMenuRepositoy {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Menu> getBySearchFilteringForUser(MenuSearchDTO search, User user) {
		Query query = entityManager.createQuery(
				"select o from Menu o where o.currentStock > 0 and o.kitchenSite.id = :idKitchenSite and year(cast(o.date as date)) = year(cast(:fecha as date)) and month(cast(o.date as date)) = month(cast(:fecha as date)) and day(cast(o.date as date)) = day(cast(:fecha as date)) and o.id not in (select t.menu.id from Ticket t where t.client.id = :idClient and year(cast(t.menu.date as date)) = year(cast(o.date as date)) and month(cast(t.menu.date as date)) = month(cast(o.date as date)) and day(cast(t.menu.date as date)) = day(cast(o.date as date)))",
				Menu.class);
		query.setParameter("idKitchenSite", search.getKitchenSite().getId());
		query.setParameter("fecha", search.getDate());
		query.setParameter("idClient", user.getId());
		return query.getResultList();
	}

	@Override
	public List<Menu> getBySearch(MenuSearchDTO search) {
		Query query = entityManager.createQuery(
				"select o from Menu o where o.currentStock > 0 and o.kitchenSite.id = :idKitchenSite and o.date = :fecha", Menu.class);
		query.setParameter("idKitchenSite", search.getKitchenSite().getId());
		query.setParameter("fecha", search.getDate());
		return query.getResultList();
	}

	@Override
	public List<Menu> getAllFilteringForUser(User user) {
		Query query = entityManager.createQuery(
				"select o from Menu o where o.id not in (select t.menu.id from Ticket t where t.client.id = :idClient and t.menu.date is not null and year(t.menu.date) = year(o.date) and month(t.menu.date) = month(o.date) and day(t.menu.date) = day(o.date))",
				Menu.class);
		query.setParameter("idClient", user.getId());
		return query.getResultList();
	}

}
