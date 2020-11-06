package unlp.info.mapaw.comedor.repository;

import java.util.List;

import unlp.info.mapaw.comedor.domain.MealEvaluation;

public interface IMealEvaluationRepository {
	
	List<MealEvaluation> getByMealId(long id);

}
