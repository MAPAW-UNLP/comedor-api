package unlp.info.mapaw.comedor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import unlp.info.mapaw.comedor.enums.TicketTypeEnum;

@Entity
@Table(name ="TICKET")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_TICKET", allocationSize = 1)
@FilterDef(name = "clienteTicket", parameters = @ParamDef(name = "idCliente", type = "long"))
@Filter(name = "clienteTicket", condition = "id_client = :idCliente")
public class Ticket extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_menu")
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private User client;
	
	@Enumerated(EnumType.STRING)
	@Column
	private TicketTypeEnum type;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public TicketTypeEnum getType() {
		return type;
	}

	public void setType(TicketTypeEnum type) {
		this.type = type;
	}
}
