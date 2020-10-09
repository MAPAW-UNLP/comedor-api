package unlp.info.mapaw.comedor.service;

import java.math.BigDecimal;
import java.util.Date;
import unlp.info.mapaw.comedor.rest.controller.RequestModel.MenuRequestModel;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.service.KitchenSiteService;
import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.domain.Meal;

import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.dto.MenuDTO;


@Service
public class MenuService extends AbstractEntityService<MenuDTO,Menu>{

	@Override
	protected MenuDTO addCustomPropertiesToDTO(Menu entity, MenuDTO dto) {
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	protected MenuDTO createEmptyDTO() {
		return new MenuDTO();
	}
	
}
