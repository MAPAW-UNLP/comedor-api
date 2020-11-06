package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.EvaluationScoreEnum;

public class MealEvaluationRequestDTO {

	private long idMeal;

	private String comments;

	private EvaluationScoreEnum score;

	public long getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(long idMeal) {
		this.idMeal = idMeal;
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
