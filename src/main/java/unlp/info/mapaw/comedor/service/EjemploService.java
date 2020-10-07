package unlp.info.mapaw.comedor.service;

import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.Ejemplo;
import unlp.info.mapaw.comedor.dto.EjemploDTO;

@Service
public class EjemploService extends AbstractEntityService<EjemploDTO, Ejemplo> {

	@Override
	protected EjemploDTO addCustomPropertiesToDTO(Ejemplo entity, EjemploDTO dto) {
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	protected EjemploDTO createEmptyDTO() {
		return new EjemploDTO();
	}

	@Override
	protected Ejemplo addCustomPropertiesToEntity(EjemploDTO dto, Ejemplo entity) {
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	protected Ejemplo createEmptyEntity() {
		return new Ejemplo();
	}
}
