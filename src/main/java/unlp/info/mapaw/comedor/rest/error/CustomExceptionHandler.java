package unlp.info.mapaw.comedor.rest.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import unlp.info.mapaw.comedor.exception.ServiceException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorDTO> handleServiceException(final ServiceException rse,
			final HttpServletRequest request) {
		ErrorDTO dto = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), rse.getMessage(), request.getRequestURI());
		return ResponseEntity.status(dto.getStatus()).contentType(MediaType.APPLICATION_JSON).body(dto);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDTO> handleServiceException(final AccessDeniedException rse,
			final HttpServletRequest request) {
		ErrorDTO dto = new ErrorDTO(HttpStatus.FORBIDDEN.value(),
				"Access denied", "", request.getRequestURI());
		return ResponseEntity.status(dto.getStatus()).contentType(MediaType.APPLICATION_JSON).body(dto);
	}
}
