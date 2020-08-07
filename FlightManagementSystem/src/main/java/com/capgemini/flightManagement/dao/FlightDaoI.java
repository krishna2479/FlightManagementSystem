package com.capgemini.flightManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.Flight;


@Repository
public interface FlightDaoI {

public void addFlight(Flight flight);
	
    public void deleteFlight(int flightId);

	public List<Flight> getAllFlight();

	public Flight findById(int flightId);

	public void updateFlight(int flightId, Flight flight);
	
}
