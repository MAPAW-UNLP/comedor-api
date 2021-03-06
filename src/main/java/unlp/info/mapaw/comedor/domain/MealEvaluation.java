package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="MEAL_EVALUATION")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_MEAL_EVALUATION", allocationSize = 1)
public class MealEvaluation extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_meal")
	private Meal meal;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private User client;
	
	private String comments;
	
	@Column
	private int score;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
