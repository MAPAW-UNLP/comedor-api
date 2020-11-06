package unlp.info.mapaw.comedor.dto;

public class MealEvaluationRequestDTO {

	private long idMeal;

	private String comments;

	private int score;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
