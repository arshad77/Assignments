package dev.task.exceptions;

public class InvalidOutcomeInputException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidOutcomeInputException(String msg) {
		super(msg);
	}
}
