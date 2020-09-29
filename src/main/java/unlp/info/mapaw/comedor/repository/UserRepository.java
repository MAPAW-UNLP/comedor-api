package unlp.info.mapaw.comedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unlp.info.mapaw.comedor.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByDni(String dni);

	User findById(long id);

	List<User> findAll();
}
