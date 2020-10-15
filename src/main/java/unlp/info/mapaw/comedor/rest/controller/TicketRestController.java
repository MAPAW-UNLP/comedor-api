package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.Ticket;
import unlp.info.mapaw.comedor.dto.TicketDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.TicketService;

@Tag(name = "Ticket", description = "API de Ticket")
@RestController
@RequestMapping("/api/ticket")
public class TicketRestController extends AbstractRestController<TicketDTO> {

	@Autowired
	private TicketService service;

	@Override
	public ResponseEntity<Collection<TicketDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.getAll(Ticket.class));
	}

	@Override
	public ResponseEntity<TicketDTO> getById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(service.get(Ticket.class, id));
	}
	
//	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
//	@PreAuthorize("hasRole('CLIENT')")
//	@PostMapping("/buy")
//	public ResponseEntity<TicketDTO> buyTicket(@RequestBody TicketDTO ticketDTO) {
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
//				.body(service.buy(ticketDTO));
//	} 
	

}
