package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.KitchenSite;
import unlp.info.mapaw.comedor.dto.KitchenSiteDTO;

@Service
public class KitchenSiteService extends AbstractEntityService<KitchenSiteDTO, KitchenSite>{

	@Override
	protected KitchenSiteDTO addCustomPropertiesToDTO(KitchenSite entity, KitchenSiteDTO dto) {
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	protected KitchenSiteDTO createEmptyDTO() {
		return new KitchenSiteDTO();
	}

	@Override
	protected KitchenSite addCustomPropertiesToEntity(KitchenSiteDTO dto, KitchenSite entity) {
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	protected KitchenSite createEmptyEntity() {
		return new KitchenSite();
	}
	
}