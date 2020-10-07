package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Faculty;
import unlp.info.mapaw.comedor.dto.FacultyDTO;

@Service
public class FacultyService extends AbstractEntityService<FacultyDTO, Faculty>{

	@Override
	protected FacultyDTO addCustomPropertiesToDTO(Faculty entity, FacultyDTO dto) {
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	protected FacultyDTO createEmptyDTO() {
		return new FacultyDTO();
	}

	@Override
	protected Faculty addCustomPropertiesToEntity(FacultyDTO dto, Faculty entity) {
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	protected Faculty createEmptyEntity() {
		return new Faculty();
	}
	
}
