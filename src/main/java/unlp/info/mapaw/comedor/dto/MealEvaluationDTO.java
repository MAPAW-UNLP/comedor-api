package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.EvaluationScoreEnum;

public class MealEvaluationDTO extends AbstractDTO {

	private MealDTO meal;

	private UserDTO client;

	private String comments;

	private EvaluationScoreEnum score;

	public MealDTO getMeal() {
		return meal;
	}

	public void setMeal(MealDTO meal) {
		this.meal = meal;
	}

	public UserDTO getClient() {
		return client;
	}

	public void setClient(UserDTO client) {
		this.client = client;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public EvaluationScoreEnum getScore() {
		return score;
	}

	public void setScore(EvaluationScoreEnum score) {
		this.score = score;
	}

}
