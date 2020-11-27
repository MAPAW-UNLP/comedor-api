package unlp.info.mapaw.comedor.exception;

public class ClientException extends RuntimeException {
	
	private static final long serialVersionUID = -1222984961140120990L;

	public ClientException(String msg) {
		super(msg);
	}

	public ClientException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
