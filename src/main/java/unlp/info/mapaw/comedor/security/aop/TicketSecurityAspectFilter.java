package unlp.info.mapaw.comedor.security.aop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.security.SecuredUser;

@Aspect
@Component
public class TicketSecurityAspectFilter {

	private static String FILTER_CLIENTE = "clienteTicket";

	@PersistenceContext
	private EntityManager entityManager;

	protected void activateFindFilter(Class<?> clase) {
		if (entityManager.unwrap(Session.class).getEnabledFilter(FILTER_CLIENTE) == null) {
			boolean cumpleConFiltro = Ticket.class.isAssignableFrom(clase);
			if (cumpleConFiltro && getUsuarioLogueado().isClient())
				this.activateTicketFilter(getUsuarioLogueado().getUser().getId());
		}
	}

	private void activateTicketFilter(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter(FILTER_CLIENTE);
		filter.setParameter("idCliente", idCliente);
	}
	
	
	@Before("execution(* unlp.info.mapaw.comedor.service.abstracts.AbstractCRUDService.findAll(Class,..)) && args(clase,..)")
	public void filterServiceFindAll(JoinPoint joinPoint, Class<?> clase) {
	    activateFindFilter(clase);
	}

	@Before("execution(* unlp.info.mapaw.comedor.service.*.get(Class,..)) && args(clase,..)")
	public void filterServiceFind(JoinPoint joinPoint, Class<?> clase) {
	    activateFindFilter(clase);
	}

	private SecuredUser getUsuarioLogueado() {
		return (SecuredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
