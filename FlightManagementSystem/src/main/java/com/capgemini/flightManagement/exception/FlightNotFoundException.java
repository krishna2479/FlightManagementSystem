package com.capgemini.flightManagement.exception;

public class FlightNotFoundException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public FlightNotFoundException() {
		
	}

	public FlightNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FlightNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightNotFoundException(String message) {
		super(message);
	}
		

	public FlightNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
