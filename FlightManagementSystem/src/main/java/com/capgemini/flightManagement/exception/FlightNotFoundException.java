package com.capgemini.flightManagement.exception;

public class FlightNotFoundException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightNotFoundException(String msg) {
		super(msg);
	}

}
