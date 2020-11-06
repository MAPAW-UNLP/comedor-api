package unlp.info.mapaw.comedor.dto;

public class MealEvaluationDTO extends AbstractDTO {

	private long idMeal;

	private long idClient;

	private String comments;

	private int score;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
