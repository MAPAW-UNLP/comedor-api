package unlp.info.mapaw.comedor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;

@Repository
public class MenuRepository implements IMenuRepositoy {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Menu> getBySearchFilteringForUser(MenuSearchDTO search, User user) {
		Query query = entityManager.createQuery(
				"SELECT o FROM Menu o WHERE o.kitchenSite.id = :idKitchenSite and o.date = :fecha and not exist (select 1 from Ticket a where a.menu.id = o.id and a.client.id = :idClient)",
				Menu.class);
		query.setParameter("idKitchenSite", search.getKitchenSite().getId());
		query.setParameter("fecha", search.getDate());
		query.setParameter("idClient", user.getId());
		return query.getResultList();
	}

	@Override
	public List<Menu> getBySearch(MenuSearchDTO search) {
		Query query = entityManager.createQuery(
				"SELECT o FROM Menu o WHERE o.kitchenSite.id = :idKitchenSite and o.date = :fecha", Menu.class);
		query.setParameter("idKitchenSite", search.getKitchenSite().getId());
		query.setParameter("fecha", search.getDate());
		return query.getResultList();
	}

	@Override
	public List<Menu> getAllFilteringForUser(User user) {
		Query query = entityManager.createQuery(
				"SELECT o FROM Menu o WHERE not exist (select 1 from Ticket a where a.menu.id = o.id and a.client.id = :idClient)",
				Menu.class);
		query.setParameter("idClient", user.getId());
		return query.getResultList();
	}

}
