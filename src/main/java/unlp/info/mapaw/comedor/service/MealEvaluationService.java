package unlp.info.mapaw.comedor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Meal;
import unlp.info.mapaw.comedor.domain.MealEvaluation;
import unlp.info.mapaw.comedor.dto.MealEvaluationDTO;
import unlp.info.mapaw.comedor.dto.MealEvaluationRequestDTO;
import unlp.info.mapaw.comedor.exception.ServiceException;
import unlp.info.mapaw.comedor.repository.impl.MealEvaluationRepository;

@Service
public class MealEvaluationService extends AbstractEntityService<MealEvaluationDTO, MealEvaluation> {

	@Autowired
	private MealEvaluationRepository mealEvaluationRepository;

	@Override
	protected MealEvaluationDTO addCustomPropertiesToDTO(MealEvaluation entity, MealEvaluationDTO dto) {
		dto.setComments(entity.getComments());
		dto.setIdClient(entity.getClient().getId());
		dto.setIdMeal(entity.getMeal().getId());
		dto.setScore(entity.getScore());
		return dto;
	}

	@Override
	protected MealEvaluation addCustomPropertiesToEntity(MealEvaluationDTO dto, MealEvaluation entity) {
		return null;
	}

	@Override
	protected MealEvaluationDTO createEmptyDTO() {
		return new MealEvaluationDTO();
	}

	@Override
	protected MealEvaluation createEmptyEntity() {
		return new MealEvaluation();
	}

	public List<MealEvaluationDTO> getEvaluationsFromMeal(long id) {
		List<MealEvaluationDTO> list = new ArrayList<MealEvaluationDTO>();
		for (MealEvaluation evaluation : mealEvaluationRepository.getByMealId(id)) {
			list.add(this.createDTO(evaluation));
		}
		return list;
	}

	public MealEvaluationDTO evaluate(MealEvaluationRequestDTO dto) {
		if (dto.getIdMeal() == 0) {
			throw new ServiceException("Id meal is required");
		}
		MealEvaluation entity = new MealEvaluation();
		Meal meal = crudService.findOne(Meal.class, dto.getIdMeal());
		entity.setMeal(meal);
		entity.setClient(this.getUsuarioLogueado().getUser());
		entity.setComments(dto.getComments());
		entity.setScore(dto.getScore());
		entity = crudService.save(entity);
		return this.createDTO(entity);
	}

}
