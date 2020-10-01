package unlp.info.mapaw.comedor.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MenuDTO extends AbstractDTO {

	private String name;

	private MealDTO meal;

	private KitchenSiteDTO kitchenSite;

	private Date date;

	private BigDecimal unitPrice;

	private int currentStock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MealDTO getMeal() {
		return meal;
	}

	public void setMeal(MealDTO meal) {
		this.meal = meal;
	}

	public KitchenSiteDTO getKitchenSite() {
		return kitchenSite;
	}

	public void setKitchenSite(KitchenSiteDTO kitchenSite) {
		this.kitchenSite = kitchenSite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

}
