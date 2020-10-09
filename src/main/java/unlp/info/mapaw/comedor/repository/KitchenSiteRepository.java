package unlp.info.mapaw.comedor.repository;

import org.springframework.data.repository.CrudRepository;
import unlp.info.mapaw.comedor.domain.KitchenSite;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenSiteRepository extends CrudRepository<KitchenSite, Long>{

	
}
