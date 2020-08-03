package com.capgemini.flightManagement.exception;

public class BookingDetailsNotFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public  BookingDetailsNotFoundException(String Message)
	{
		super(Message);
	}

}
