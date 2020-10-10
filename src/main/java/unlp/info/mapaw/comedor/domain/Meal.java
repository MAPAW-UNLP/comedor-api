package unlp.info.mapaw.comedor.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="MEAL")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_MEAL", allocationSize = 1)
public class Meal extends AbstractEntity {

	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "id_meal")
	private List<Dish> items= new ArrayList<>();
	
	@Column(name="suitable_for_vegetarians")
	private boolean suitableForVegetarians;
	
	@Column(name="suitable_for_celiacs")
	private boolean suitableForCeliacs;
	
	private String observations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getItems() {
		return items;
	}

	public void setItems(List<Dish> items) {
		this.items = items;
	}

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

	public boolean isSuitableForCeliacs() {
		return suitableForCeliacs;
	}

	public void setSuitableForCeliacs(boolean suitableForCeliacs) {
		this.suitableForCeliacs = suitableForCeliacs;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
}
