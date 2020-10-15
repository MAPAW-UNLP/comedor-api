package unlp.info.mapaw.comedor.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -1222984961140120990L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
