package com.capgemini.flightManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = FlightException.class)
	public ResponseEntity<Object> handleNullException(FlightException exception)
	{
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = FlightNotFoundException.class)
	public ResponseEntity<Object> handleNullException(FlightNotFoundException exception)
	{
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
}
