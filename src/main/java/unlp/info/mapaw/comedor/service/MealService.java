package unlp.info.mapaw.comedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Dish;
import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.dto.DishDTO;
import unlp.info.mapaw.comedor.dto.MealDTO;

@Service
public class MealService extends AbstractEntityService<MealDTO,Meal>{

	@Autowired
	private DishService dishService;
	
	@Override
	protected MealDTO addCustomPropertiesToDTO(Meal entity, MealDTO dto) {
		dto.setName(entity.getName());
		dto.setSuitableForCeliacs(entity.isSuitableForCeliacs());
		dto.setSuitableForVegetarians(entity.isSuitableForVegetarians());
		dto.setObservations(entity.getObservations());
		for(Dish dish: entity.getItems()) {
			dto.getItems().add(dishService.createDTO(dish));
		}
		return dto;
	}

	@Override
	protected MealDTO createEmptyDTO() {
		return new MealDTO();
	}

	@Override
	protected Meal addCustomPropertiesToEntity(MealDTO dto, Meal entity) {
		entity.setName(dto.getName());
		entity.setSuitableForCeliacs(dto.isSuitableForCeliacs());
		entity.setSuitableForVegetarians(dto.isSuitableForVegetarians());
		entity.setObservations(dto.getObservations());
		for(DishDTO dishDTO: dto.getItems()) {
			entity.getItems().add(this.crudService.findOne(Dish.class, dishDTO.getId()));
		}
		return entity;
	}

	@Override
	protected Meal createEmptyEntity() {
		return new Meal();
	}
	
}
