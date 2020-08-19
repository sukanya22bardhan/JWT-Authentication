package com.cg.iter.authenticationservice.exception;

public class ValidationException extends RuntimeException {

	/**
	 * Name: validationException 
	 * Description: This exception will be handled if user
	 * inputs are not valid.
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);

	}
}
