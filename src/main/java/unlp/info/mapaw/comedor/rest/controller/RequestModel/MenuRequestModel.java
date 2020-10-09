package unlp.info.mapaw.comedor.rest.controller.RequestModel;

import java.math.BigDecimal;
import java.util.Date;

public class MenuRequestModel {
	private String name;
	private Long kitchenSiteID;
	private Long mealID;
	private Date date;
	private BigDecimal unitPrice;
	private int currentStock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getKitchenSiteID() {
		return kitchenSiteID;
	}
	public void setKitchenSiteID(Long kitchenSiteID) {
		this.kitchenSiteID = kitchenSiteID;
	}
	public Long getMealID() {
		return mealID;
	}
	public void setMealID(Long mealID) {
		this.mealID = mealID;
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

