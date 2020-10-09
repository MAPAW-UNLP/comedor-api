package unlp.info.mapaw.comedor.repository;

import org.springframework.data.repository.CrudRepository;
import unlp.info.mapaw.comedor.domain.Menu;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

	
	
}
