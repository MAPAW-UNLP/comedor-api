package unlp.info.mapaw.comedor.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="MENU")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_MENU", allocationSize = 1)
public class Menu extends AbstractEntity {
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_meal")
	private Meal meal;

	@ManyToOne
	@JoinColumn(name = "id_kitchen_site")
	private KitchenSite kitchenSite;
	
	private Date date;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@Column(name = "current_stock")
	private int currentStock;
	
	@Column(name = "anticipation_days")
	private int anticipationDays;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public KitchenSite getKitchenSite() {
		return kitchenSite;
	}

	public void setKitchenSite(KitchenSite kitchenSite) {
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

	public int getAnticipationDays() {
		return anticipationDays;
	}

	public void setAnticipationDays(int anticipationDays) {
		this.anticipationDays = anticipationDays;
	}
	
	public void discountStock() {
		this.setCurrentStock(this.getCurrentStock() - 1);
	}
}
