package com.capgemini.flightManagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightManagement.dto.Flight;
import com.capgemini.flightManagement.exception.FlightException;
import com.capgemini.flightManagement.service.FlightServiceI;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@Validated
public class FlightController {
	
	@Autowired
	FlightServiceI flightservice;
	
	/**********************************************************************************
	* Method        addFlight
	* Description   To add flight with details 
	* returns       This method return string to tell if new flight object is created or not. 
	* Created on    28-July-2020
	* Created By    Krishna Kant
	* @throws Exception
	**********************************************************************************/
	
	@PostMapping("/addFlight")
	public ResponseEntity<Object> addFlight(@Valid @RequestBody Flight flight) throws Exception
	{
		flightservice.addFlight(flight);
		return new ResponseEntity<>("Flight added Successfully",HttpStatus.OK);
	}
	
	
	/*********************************************************************************************************************
	 * Method: viewAllFlight
	 * Description: handler mapped with get function to fetch the flight list
	 * @return flightList: list containing the objects of class Flight from the database
	 * Created On   29-July-2020            
     * Created By - Krishna Kant 
	 ***********************************************************************************************************************/
	
	@GetMapping("/getAllFlight")
	public ResponseEntity<Object> viewAllFlight()
	{
		return new ResponseEntity<>(flightservice.getAllFlight(),HttpStatus.OK);
	}
	
	
	/*********************************************************************************************************************
	 * Method: deleteFlight
	 * Description: handler mapped with delete function to delete the flight object with flightId
	 * @param flightId
	 * @return This method return the message if the flight deleted or not
	 * Created On   29-July-2020            
     * Created By - Krishna Kant 
	 ***********************************************************************************************************************/
	
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<Object> deleteFlight(@PathVariable("flightId") int flightId)
	{
		flightservice.deleteFlight(flightId);
		return new ResponseEntity<>("Flight deleted Successfully", HttpStatus.OK);
	}
	
	
	/*********************************************************************************************************************
	 * Method: updateFlight
	 * Description: handler mapped with put function to edit the flight details with flightId
	 * @param flightId
	 * @return This method return the message if the flight details updated or not
	 * @throws FlightException if the seating capacity is more than 200 
	 * Created On   29-July-2020            
     * Created By - Krishna Kant 
	 ***********************************************************************************************************************/
	
	@PutMapping ("/updateFlight/{flightId}")
	public ResponseEntity<Object> updateFlight(@PathVariable("flightId") int flightId,@RequestBody Flight flight)
	{
		if(flight.getSeatCapacity()>200)throw new FlightException("Seating Capacity should not exceeds 200");
	    flightservice.updateFlight(flightId, flight);
	    return new ResponseEntity<>("Flight Updated SuccessFully", HttpStatus.OK);
	}
	
	
	/*********************************************************************************************************************
	 * Method: findById
	 * Description: handler mapped with get function to fetch the flight details with flightId
	 * @param flightId
	 * @return flight: details of the flight mapped with given flightId
	 * Created On   29-July-2020            
     * Created By - Krishna Kant 
	 ***********************************************************************************************************************/
	
	@GetMapping("/find/{flightId}")
	public ResponseEntity<Object> findById(@PathVariable("flightId") int flightId)
	{
		return new ResponseEntity<>(flightservice.findById(flightId),HttpStatus.OK);
	}
	
}
