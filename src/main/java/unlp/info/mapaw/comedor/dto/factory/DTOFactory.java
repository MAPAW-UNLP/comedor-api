package unlp.info.mapaw.comedor.dto.factory;

public abstract class DTOFactory<T, DTO> {

	public abstract DTO createDTO(T entity);
	
}
