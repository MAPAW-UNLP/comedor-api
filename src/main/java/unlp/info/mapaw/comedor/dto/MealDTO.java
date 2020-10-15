package unlp.info.mapaw.comedor.dto;

import java.util.ArrayList;
import java.util.List;

public class MealDTO extends AbstractDTO {

	private String name;

	private List<DishDTO> items = new ArrayList<>();

	private boolean suitableForVegetarians;

	private boolean suitableForCeliacs;
	
	private String observations;

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DishDTO> getItems() {
		return items;
	}

	public void setItems(List<DishDTO> items) {
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

}
