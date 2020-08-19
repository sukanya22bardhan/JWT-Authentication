package com.cg.iter.authenticationservice.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Name: userNotFoundException 
	 * Description: This exception will be handled if
	 * the requested user in not their in database.
	 */

	public UserNotFoundException(String message) {
		super(message);
	}

}
