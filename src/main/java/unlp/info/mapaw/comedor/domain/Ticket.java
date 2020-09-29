package unlp.info.mapaw.comedor.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import unlp.info.mapaw.comedor.enums.TicketTypeEnum;

//@Entity
//@Table(name ="TICKET")
//@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_TICKET", allocationSize = 1)
public class Ticket extends AbstractEntity {

	private Menu menu;
	
	private User client;
	
	private TicketTypeEnum type;

}
