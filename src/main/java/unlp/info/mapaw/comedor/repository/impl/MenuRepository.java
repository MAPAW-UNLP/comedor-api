package unlp.info.mapaw.comedor.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.repository.IMenuRepositoy;

@Repository
public class MenuRepository implements IMenuRepositoy {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Menu> getWithStock() {
		Query query = entityManager.createQuery(
				"select o from Menu o where o.currentStock > 0", Menu.class);
		return query.getResultList();
	}

}
