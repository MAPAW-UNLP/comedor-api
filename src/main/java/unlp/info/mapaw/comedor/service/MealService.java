package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.dto.MealDTO;

@Service
public class MealService extends AbstractEntityService<MealDTO,Meal>{

	@Override
	protected MealDTO addCustomPropertiesToDTO(Meal entity, MealDTO dto) {
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	protected MealDTO createEmptyDTO() {
		return new MealDTO();
	}
	
}
