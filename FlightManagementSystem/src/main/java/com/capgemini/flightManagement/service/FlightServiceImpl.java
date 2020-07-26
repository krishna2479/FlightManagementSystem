package com.capgemini.flightManagement.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightManagement.dao.FlightDaoI;
import com.capgemini.flightManagement.dto.Flight;
import com.capgemini.flightManagement.exception.FlightException;

@Transactional
@Service
public class FlightServiceImpl implements FlightServiceI {

	@Autowired
	FlightDaoI flightdao;
	
	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		if(flight.getSeatCapacity()>200)throw new FlightException("Seating Capacity should not exceeds 200");
		flightdao.addFlight(flight);
	}

	@Override
	public void deleteFlight(int flightId) {
		// TODO Auto-generated method stub
		flightdao.deleteFlight(flightId);
	}

	@Override
	public void updateFlight(int flightId, Flight flight) {
		// TODO Auto-generated method stub
		flightdao.updateFlight(flightId, flight);
	}

	@Override
	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return flightdao.getAllFlight();
	}

	@Override
	public Flight findById(int flightId) {
		// TODO Auto-generated method stub
		return flightdao.findById(flightId);
	}
	
}
