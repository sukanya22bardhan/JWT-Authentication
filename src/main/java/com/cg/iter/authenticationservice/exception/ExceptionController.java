package com.cg.iter.authenticationservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.iter.authenticationservice.entity.ErrorMessage;

/**
 * Name: ExceptionController 
 * Description: It contains the common exception
 * handler for all the controllers.
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	private long currentTimeMillis = System.currentTimeMillis();
	private String errorMsg = "Some thing went wrong!";

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), errorMsg, currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

	/**
	 * Name: validationException 
	 * Description: This exception will be handled if user
	 * inputs are not valid.
	 */
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ErrorMessage> validationException(ValidationException ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Invalid input.", currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Name: nullParameter 
	 * Description: This exception will be handled if request
	 * comes with null values.
	 */
	@ExceptionHandler(NullParameterException.class)
	public final ResponseEntity<ErrorMessage> nullParameter(NullParameterException ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), errorMsg, currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Name: userNotFoundException 
	 * Description: This exception will be handled if
	 * the requested user in not their in database.
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), errorMsg, currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
