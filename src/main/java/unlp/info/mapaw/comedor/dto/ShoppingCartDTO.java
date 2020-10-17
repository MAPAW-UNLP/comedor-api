package unlp.info.mapaw.comedor.dto;

import java.util.List;

public class ShoppingCartDTO {
	
	private List<ItemShoppingCartDTO> items;

	public List<ItemShoppingCartDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemShoppingCartDTO> items) {
		this.items = items;
	}

}
