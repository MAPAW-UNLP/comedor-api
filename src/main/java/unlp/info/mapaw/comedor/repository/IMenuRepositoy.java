package unlp.info.mapaw.comedor.repository;

import java.util.List;

import unlp.info.mapaw.comedor.domain.Menu;

public interface IMenuRepositoy {

	List<Menu> getWithStock();

}
