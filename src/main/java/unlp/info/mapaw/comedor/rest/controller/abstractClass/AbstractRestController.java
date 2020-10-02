package unlp.info.mapaw.comedor.rest.controller.abstractClass;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import unlp.info.mapaw.comedor.dto.AbstractDTO;

public abstract class AbstractRestController<TT extends AbstractDTO> {

	@GetMapping(value = "/", produces = { "application/json" })
	//@PreAuthorize(RoleExpressionsUtil.hasAnyRole)
	public abstract @ResponseBody ResponseEntity<Collection<TT>> getAll();

	@GetMapping(value = "/{id}", produces = { "application/json" })
	//@PreAuthorize(RoleExpressionsUtil.hasAnyRole)
	public abstract @ResponseBody ResponseEntity<TT> getById(@PathVariable("id") Long id);
}
