package unlp.info.mapaw.comedor.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.dto.KitchenSiteDTO;
import unlp.info.mapaw.comedor.rest.controller.abstractClass.AbstractRestController;
import unlp.info.mapaw.comedor.service.KitchenSiteService;

@Tag(name = "KitchenSite", description = "API de Sede")
@RestController
@RequestMapping("/api/kitchenSite")
public class KitchenSiteRestController extends AbstractRestController<KitchenSiteDTO> {

	@Autowired
	private KitchenSiteService service;
	
	@Override
	public ResponseEntity<Collection<KitchenSiteDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.getAll(KitchenSite.class));
	}

	@Override
	public ResponseEntity<KitchenSiteDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
		        .body(service.get(KitchenSite.class, id));
	}
}
