package unlp.info.mapaw.comedor.dto;

import unlp.info.mapaw.comedor.enums.EvaluationScoreEnum;

public class MealEvaluationDTO extends AbstractDTO {

	private long idMeal;

	private long idClient;

	private String comments;

	private EvaluationScoreEnum score;

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

	public long getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(long idMeal) {
		this.idMeal = idMeal;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

}
