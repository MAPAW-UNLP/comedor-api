package unlp.info.mapaw.comedor.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateMenusDTO {
	
	private String name;

	private MealDTO meal;

	private int anticipationDays;

	private int stock;

	private BigDecimal unitPrice;

	private List<KitchenSiteDTO> kitchenSites;

	private List<Date> habilitedDates;

	public MealDTO getMeal() {
		return meal;
	}

	public void setMeal(MealDTO meal) {
		this.meal = meal;
	}

	public int getAnticipationDays() {
		return anticipationDays;
	}

	public void setAnticipationDays(int anticipationDays) {
		this.anticipationDays = anticipationDays;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<KitchenSiteDTO> getKitchenSites() {
		return kitchenSites;
	}

	public void setKitchenSites(List<KitchenSiteDTO> kitchenSites) {
		this.kitchenSites = kitchenSites;
	}

	public List<Date> getHabilitedDates() {
		return habilitedDates;
	}

	public void setHabilitedDates(List<Date> habilitedDates) {
		this.habilitedDates = habilitedDates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
