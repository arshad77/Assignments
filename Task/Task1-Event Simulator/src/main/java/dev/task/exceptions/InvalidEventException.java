package dev.task.exceptions;

public class InvalidEventException extends Exception{
	
	private static final long serialVersionUID = 2L;

	public InvalidEventException(String msg) {
		super(msg);
	}
}