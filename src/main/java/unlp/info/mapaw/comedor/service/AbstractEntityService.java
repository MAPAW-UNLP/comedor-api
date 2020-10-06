package unlp.info.mapaw.comedor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unlp.info.mapaw.comedor.domain.AbstractEntity;
import unlp.info.mapaw.comedor.dto.AbstractDTO;
import unlp.info.mapaw.comedor.service.abstracts.AbstractCRUDService;

@Service
public abstract class AbstractEntityService<DTO extends AbstractDTO, T extends AbstractEntity> {

	@Autowired
	private AbstractCRUDService crudService;
	
	protected abstract DTO addCustomPropertiesToDTO(T entity, DTO dto);
	
	protected abstract DTO createEmptyDTO();
	
	public List<DTO> getAll(Class<T> entityClass) {
		List<DTO> lista = new ArrayList<DTO>();
		for (T entity : crudService.findAll(entityClass)) {
			lista.add(createDTO(entity));
		}
		return lista;
	}

	public DTO get(Class<T> entityClass, Long id) {
		T entity = crudService.findOne(entityClass, id);
		return createDTO(entity);
	}
	
	protected DTO createDTO(T entity) {
		DTO dto = createEmptyDTO();
		dto.setId(entity.getId());
		this.addCustomPropertiesToDTO(entity, dto);
		return dto;
	}
}
