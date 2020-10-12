package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="KITCHEN_SITE", schema="public")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_KITCHEN_SITE", allocationSize = 1)
public class KitchenSite extends AbstractEntity {

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
