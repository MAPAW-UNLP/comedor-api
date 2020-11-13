package unlp.info.mapaw.comedor.dto;

import java.util.Date;

public class SearchTicketDTO {
	
	private KitchenSiteDTO kitchenSite;
	
	private Date date;
	
	private String dni;

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
