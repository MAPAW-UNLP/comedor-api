package unlp.info.mapaw.comedor.service.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import unlp.info.mapaw.comedor.domain.AbstractEntity;

public interface AbstractJPARepository extends JpaRepository<AbstractEntity, Long> {

}
