package unlp.info.mapaw.comedor.dto;

import java.util.Date;

public class MenuSearchDTO {
	
	private KitchenSiteDTO kitchenSite;
	
	private Date date;

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
}
