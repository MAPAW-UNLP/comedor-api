package unlp.info.mapaw.comedor.rest.controller.abstractClass;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import unlp.info.mapaw.comedor.dto.AbstractDTO;

public abstract class AbstractRestController<TT extends AbstractDTO> {

	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping(value = "/", produces = { "application/json" })
	public abstract @ResponseBody ResponseEntity<Collection<TT>> getAll();

	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public abstract @ResponseBody ResponseEntity<TT> getById(@PathVariable("id") Long id);
}
