package unlp.info.mapaw.comedor.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="EJEMPLO")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_EJEMPLO", allocationSize = 1)
public class Ejemplo extends AbstractEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
