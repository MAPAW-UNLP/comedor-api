package unlp.info.mapaw.comedor.repository;

import org.springframework.data.repository.CrudRepository;
import unlp.info.mapaw.comedor.domain.Meal;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long>{

}
