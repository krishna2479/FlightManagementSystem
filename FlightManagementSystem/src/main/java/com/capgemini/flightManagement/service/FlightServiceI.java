package com.capgemini.flightManagement.service;

import java.util.List;

import com.capgemini.flightManagement.dto.Flight;

public interface FlightServiceI {
	
public void addFlight(Flight flight ) throws Exception;
	
	public void deleteFlight(int flightId );
	
	public void updateFlight(int flightId, Flight flight);

	public List<Flight> getAllFlight();
	
	public Flight findById(int flightId);
	

}
