package exceptions;

public class ServiceNotAvailbleException extends Exception{
	private static final long serialVersionUID = 2L;

	public ServiceNotAvailbleException(String msg) {
		super(msg);
	}
}
