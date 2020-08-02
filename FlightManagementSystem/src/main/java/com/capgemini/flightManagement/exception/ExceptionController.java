package com.capgemini.flightManagement.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
@ResponseBody
public class ExceptionController
 {
	
	@ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<InvalidInput> handleConstraintViolation(ConstraintViolationException exception, WebRequest request)
    {
        List<String> details = exception.getConstraintViolations().parallelStream().map(e -> e.getMessage()).collect(Collectors.toList());
 
        InvalidInput error = new InvalidInput("BAD_REQUEST", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
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
