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
	
	/***************************************************************************************************
	 * Method - addFlight
	 * description - add the new object of class Flight
	 * @param flighId - Flight's id
	 * @return - object of class Flight
	 * @author - Krishna Kant
	 * created date - 28-JULY-2020
	 * @throws FlightException
	 **************************************************************************************************/
	@Override
	public void addFlight(Flight flight) throws Exception{

		if(flight.getSeatCapacity()>200)throw new FlightException("Seating Capacity should not exceeds 200");
		flightdao.addFlight(flight);
	}

	/************************************************************************************************
	 * Method - deleteFlight
	 * description - delete the object of class Flight by flightId
	 * @param flightId - Flight's id
	 * @return - null
	 * @author - Krishna Kant
	 * created date - 28-JULY-2020
	 ************************************************************************************************/
	@Override
	public void deleteFlight(int flightId) {
		
		flightdao.deleteFlight(flightId);
	}

	/************************************************************************************************
	 * Method - updateFlight
	 * description - update the object of class Flight with reference of flightId
	 *               and save the updated object
	 * @param flightId - Flight's id
	 * @param updatedFlight - new object to store updated values
	 * @return - updated object of class Flight
	 * @author - Krishna Kant
	 * created date - 29-JULY-2020
	 ************************************************************************************************/
	@Override
	public void updateFlight(int flightId, Flight flight) {
		
		flightdao.updateFlight(flightId, flight);
	}

	/************************************************************************************************
	 * Method - getAllFlight
	 * description - get all the data from the table flight_table
	 * @return - all the object of class Flight
	 * @author - Krishna Kant
	 * created date - 29-JULY-2020
	 ***********************************************************************************************/
	@Override
	public List<Flight> getAllFlight() {
		
		return flightdao.getAllFlight();
	}

	/**************************************************************************************************
	 * Method - findById
	 * description - find the flight associated with the given flightId from the table flight_table
	 * @return - the object of class Flight
	 * @author - Krishna Kant
	 * created date - 29-JULY-2020
	 ****************************************************************************************************/
	@Override
	public Flight findById(int flightId) {
		
		return flightdao.findById(flightId);
	}
	
}
