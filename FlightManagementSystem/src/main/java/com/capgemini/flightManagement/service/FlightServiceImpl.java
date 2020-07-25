package com.capgemini.flightManagement.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightManagement.dao.FlightDaoI;
import com.capgemini.flightManagement.dto.Flight;

@Transactional
@Service
public class FlightServiceImpl implements FlightServiceI {

	@Autowired
	FlightDaoI flightdao;
	
	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
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

}
