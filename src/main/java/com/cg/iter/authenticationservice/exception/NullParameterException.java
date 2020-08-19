package com.cg.iter.authenticationservice.exception;

@SuppressWarnings("serial")
public class NullParameterException extends RuntimeException {

	/**
	 * Name: nullParameter 
	 * Description: This exception will be handled if request
	 * comes with null values.
	 */
	public NullParameterException(String message) {
		super(message);
	}

}
