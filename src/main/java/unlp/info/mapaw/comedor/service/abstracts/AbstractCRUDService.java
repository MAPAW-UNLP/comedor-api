package unlp.info.mapaw.comedor.service.abstracts;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unlp.info.mapaw.comedor.domain.AbstractEntity;

@Service
@Transactional(readOnly = true)
public class AbstractCRUDService {
	
	@Autowired
	private AbstractJPARepository abstractJPARepository;

	@PersistenceContext
	private EntityManager em;
	
	public <T extends AbstractEntity> T findOne(Class<T> entityClass, long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(entityClass);
		Root<T> c = q.from(entityClass);
		q.where(cb.equal(c.get("id"), id));
		q.select(c);
		return em.createQuery(q).getSingleResult();
	}

	public <T extends AbstractEntity> List<T> findAll(Class<T> entityClass) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(entityClass);
		Root<T> c = q.from(entityClass);
		q.select(c);
		return this.findAll(q);
	}
	
	private <T extends AbstractEntity> List<T> findAll(CriteriaQuery<T> q) {
		return em.createQuery(q).getResultList();
	}

}
