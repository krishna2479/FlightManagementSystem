package com.capgemini.flightManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.Flight;
import com.capgemini.flightManagement.exception.FlightNotFoundException;

@Repository
public class FlightDaoImpl implements FlightDaoI {
	
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public void addFlight(Flight flight) throws Exception {

		entitymanager.persist(flight);
	}

	@Override
	public void deleteFlight(int flightId) {
	
		Flight flight=entitymanager.find(Flight.class, flightId);
		if(flight==null) { 
			throw new FlightNotFoundException("No such FlightId found to delete");
		}
		else
			entitymanager.remove(flight);
			entitymanager.flush();
		
	}

	@Override
	public List<Flight> getAllFlight() {
		
		Query query = entitymanager.createQuery("from Flight flight");
		return query.getResultList();
	}

	@Override
	public Flight findById(int flightId) {
		
		Flight flight = entitymanager.find(Flight.class, flightId);
		if(flight==null) {
			throw new FlightNotFoundException("Flight not available");
		}else
		return flight;
	}
	

	@Override
	public void updateFlight(int flightId, Flight flight) {
		
		Flight flightobject=entitymanager.find(Flight.class, flightId);
		if(flightobject==null) { 
			throw new FlightNotFoundException("FlightId not available to update");
		}
		else {
		flightobject.setFlightModel(flight.getFlightModel());
		flightobject.setCarrierName(flight.getCarrierName());
		flightobject.setSeatCapacity(flight.getSeatCapacity());
		entitymanager.persist(flightobject);
		}
	}

}
