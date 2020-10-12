package unlp.info.mapaw.comedor.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="FACULTY")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_FACULTY", allocationSize = 1)
public class Faculty extends AbstractEntity {
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
