package unlp.info.mapaw.comedor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.dto.CreateMenusDTO;
import unlp.info.mapaw.comedor.dto.KitchenSiteDTO;
import unlp.info.mapaw.comedor.dto.MenuDTO;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;
import unlp.info.mapaw.comedor.repository.IMenuRepositoy;

@Service
public class MenuService extends AbstractEntityService<MenuDTO, Menu> {

	@Autowired
	private KitchenSiteService kitchenService;

	@Autowired
	private MealService mealService;

	@Autowired
	private IMenuRepositoy menuRepository;

	@Override
	protected MenuDTO addCustomPropertiesToDTO(Menu entity, MenuDTO dto) {
		dto.setName(entity.getName());
		dto.setCurrentStock(entity.getCurrentStock());
		dto.setDate(entity.getDate());
		dto.setKitchenSite(kitchenService.createDTO(entity.getKitchenSite()));
		dto.setMeal(mealService.createDTO(entity.getMeal()));
		return dto;
	}

	@Override
	protected MenuDTO createEmptyDTO() {
		return new MenuDTO();
	}

	@Override
	protected Menu addCustomPropertiesToEntity(MenuDTO dto, Menu entity) {
		entity.setCurrentStock(dto.getCurrentStock());
		entity.setDate(dto.getDate());
		entity.setName(dto.getName());
		entity.setUnitPrice(dto.getUnitPrice());
		entity.setKitchenSite(this.crudService.findOne(KitchenSite.class, dto.getKitchenSite().getId()));
		entity.setMeal(this.crudService.findOne(Meal.class, dto.getMeal().getId()));
		return entity;
	}

	@Override
	protected Menu createEmptyEntity() {
		return new Menu();
	}

	@Override
	public List<MenuDTO> getAll(Class<Menu> entityClass) {
		List<MenuDTO> lista = new ArrayList<MenuDTO>();
		for (Menu entity : this.getUsuarioLogueado().isClient()
				? menuRepository.getAllFilteringForUser(this.getUsuarioLogueado().getUser())
				: crudService.findAll(entityClass)) {
			lista.add(createDTO(entity));
		}
		return lista;
	}

	public List<MenuDTO> getBySearch(MenuSearchDTO search) {
		List<Menu> menus = new ArrayList<>();
		if (this.getUsuarioLogueado().isClient())
			menus = menuRepository.getBySearchFilteringForUser(search, this.getUsuarioLogueado().getUser());
		else
			menus = menuRepository.getBySearch(search);
		List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
		for (Menu menu : menus) {
			menusDTO.add(this.createDTO(menu));
		}
		return menusDTO;
	}

	public List<MenuDTO> createFrom(CreateMenusDTO createMenusDTO) {
		List<Menu> menusCreates = new ArrayList<Menu>();
		Meal meal = this.crudService.findOne(Meal.class, createMenusDTO.getMeal().getId());
		for (KitchenSiteDTO kitchenSiteDTO : createMenusDTO.getKitchenSites()) {
			KitchenSite kitchenSite = crudService.findOne(KitchenSite.class, kitchenSiteDTO.getId());
			for (Date date : createMenusDTO.getHabilitedDates()) {
				Menu menu = new Menu();
				menu.setAnticipationDays(createMenusDTO.getAnticipationDays());
				menu.setCurrentStock(createMenusDTO.getStock());
				menu.setName(createMenusDTO.getName());
				menu.setMeal(meal);
				menu.setKitchenSite(kitchenSite);
				menu.setDate(date);
				menu.setUnitPrice(createMenusDTO.getUnitPrice());
				menu = crudService.save(menu);
				menusCreates.add(menu);
			}
		}
		List<MenuDTO> menusDTOSCreates = new ArrayList<MenuDTO>();
		for (Menu menu : menusCreates) {
			menusDTOSCreates.add(this.createDTO(menu));
		}
		return menusDTOSCreates;
	}

}
