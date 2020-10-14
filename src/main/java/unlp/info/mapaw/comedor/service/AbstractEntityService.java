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
	protected AbstractCRUDService crudService;
	
	protected abstract DTO addCustomPropertiesToDTO(T entity, DTO dto);
	
	protected abstract T addCustomPropertiesToEntity(DTO dto, T entity);
	
	protected abstract DTO createEmptyDTO();
	
	protected abstract T createEmptyEntity();
	
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
	
	public DTO save(DTO dto) {
		T entity = this.createEntityFromDTO(dto);
		entity = crudService.save(entity);
		return createDTO(entity);
	}

	protected T createEntityFromDTO(DTO dto) {
		T entity = this.createEmptyEntity();
		this.addCustomPropertiesToEntity(dto, entity);
		return entity;
	}
	
	public DTO update(Class<T> entityClass, DTO dto) {
		T entity = this.crudService.findOne(entityClass, dto.getId());
		crudService.save(entity);
		return createDTO(entity);
	}
	
	public void delete(Class<T> entityClass, Long id) {
		crudService.delete(entityClass, id);
	}
}
