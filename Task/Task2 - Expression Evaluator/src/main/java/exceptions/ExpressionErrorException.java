package exceptions;

public class ExpressionErrorException extends Exception{
	private static final long serialVersionUID = 1L;

	public ExpressionErrorException(String msg) {
		super(msg);
	}
}
