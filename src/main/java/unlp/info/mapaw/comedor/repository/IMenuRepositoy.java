package unlp.info.mapaw.comedor.repository;

import java.util.List;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.User;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;

public interface IMenuRepositoy {

	List<Menu> getBySearchFilteringForUser(MenuSearchDTO search, User user);
	
	List<Menu> getBySearch(MenuSearchDTO search);
	
	List<Menu> getAllFilteringForUser(User user);


}
