package unlp.info.mapaw.comedor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.domain.Menu;
import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.dto.CreateMenusDTO;
import unlp.info.mapaw.comedor.dto.KitchenSiteDTO;
import unlp.info.mapaw.comedor.dto.MenuDTO;
import unlp.info.mapaw.comedor.dto.MenuSearchDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;
import unlp.info.mapaw.comedor.repository.IMenuRepositoy;

@Service
public class MenuService extends AbstractEntityService<MenuDTO, Menu> {

	@Autowired
	private KitchenSiteService kitchenService;

	@Autowired
	private MealService mealService;

	@Autowired
	private IMenuRepositoy menuRepository;

	@Autowired
	private TicketService ticketService;

	@Override
	protected MenuDTO addCustomPropertiesToDTO(Menu entity, MenuDTO dto) {
		dto.setName(entity.getName());
		dto.setCurrentStock(entity.getCurrentStock());
		dto.setDate(entity.getDate());
		dto.setUnitPrice(entity.getUnitPrice());
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
		List<Ticket> tickets = crudService.findAll(Ticket.class);
		List<Date> oldMenus = this.getDatesForTicket(tickets);
		for (Menu entity : menuRepository.getWithStock()) {
			if (!this.anyDateIsSameDay(oldMenus, entity.getDate())) {
				lista.add(createDTO(entity));
			}
		}
		return lista;
	}

	private boolean anyDateIsSameDay(List<Date> oldMenus, Date fecha) {
		for (Date date : oldMenus) {
			if (DateUtils.isSameDay(date, fecha))
				return true;
		}
		return false;
	}

	private List<Date> getDatesForTicket(List<Ticket> tickets) {
		List<Date> menuses = new ArrayList<Date>();
		for (Ticket ti : tickets) {
			menuses.add(ti.getMenu().getDate());
		}
		return menuses;

	}

	public List<MenuDTO> getBySearch(MenuSearchDTO search) {
		if (search.getDate() == null) {
			throw new ServiceException("Date is required");
		}
		if (search.getKitchenSite() == null) {
			throw new ServiceException("Kitchen Site is required");
		}
		if (crudService.findOne(KitchenSite.class, search.getKitchenSite().getId()) == null) {
			throw new ServiceException("Kitchen Site not exists");
		}
		List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
		for (MenuDTO menu : this.getAll(Menu.class)) {
			if (DateUtils.isSameDay(menu.getDate(), search.getDate())
					&& menu.getKitchenSite().getId() == search.getKitchenSite().getId())
				menusDTO.add(menu);
		}
		return menusDTO;
	}

	public List<MenuDTO> createFrom(CreateMenusDTO createMenusDTO) {
		this.validate(createMenusDTO);
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

	private void validate(CreateMenusDTO createMenusDTO) {
		if (createMenusDTO.getMeal() == null) {
			throw new ServiceException("Meal is required");
		}
		if (createMenusDTO.getUnitPrice() == null) {
			throw new ServiceException("Unit Price is required");
		}
		if (createMenusDTO.getHabilitedDates().isEmpty()) {
			throw new ServiceException("Habilited Dates is required");
		}
		if (createMenusDTO.getStock() < 0) {
			throw new ServiceException("Stock must be greather than 0");
		}
		if (createMenusDTO.getAnticipationDays() <= 0) {
			throw new ServiceException("Stock must be equal or greather than 0");
		}

	}

}
