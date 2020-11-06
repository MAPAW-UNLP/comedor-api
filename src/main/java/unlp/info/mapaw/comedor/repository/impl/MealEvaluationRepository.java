package unlp.info.mapaw.comedor.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.MealEvaluation;
import unlp.info.mapaw.comedor.repository.IMealEvaluationRepository;

@Repository
public class MealEvaluationRepository implements IMealEvaluationRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<MealEvaluation> getByMealId(long id) {
		Query query = entityManager.createQuery(
				"select o from MealEvaluation o where o.meal.id = :idMeal", MealEvaluation.class);
		
		query.setParameter("idMeal", id);
		return query.getResultList();
	}

}
