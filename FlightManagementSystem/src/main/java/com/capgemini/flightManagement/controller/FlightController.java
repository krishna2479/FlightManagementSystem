package com.capgemini.flightManagement.controller;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@RestController
public class FlightController {
	
	@Autowired
	FlightServiceI flightservice;
	
	@PostMapping("/addFlight")
	public ResponseEntity<Object> addFlight(@Validated @RequestBody Flight flight)
	{
		flightservice.addFlight(flight);
		return new ResponseEntity<>("Flight added Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getAllFlight")
	public ResponseEntity<Object> viewAllFlight()
	{
		return new ResponseEntity<>(flightservice.getAllFlight(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<Object> deleteFlight(@PathVariable("flightId") int flightId)
	{
		flightservice.deleteFlight(flightId);
		return new ResponseEntity<>("Flight deleted Successfully", HttpStatus.OK);
	}
	
	@PutMapping ("/updateFlight/{flightId}")
	public ResponseEntity<Object> updateFlight(@PathVariable("flightId") int flightId,@RequestBody Flight flight)
	{
		if(flight.getSeatCapacity()>200)throw new FlightException("Seating Capacity should not exceeds 200");
	    flightservice.updateFlight(flightId, flight);
	    return new ResponseEntity<>("Flight Updated SuccessFully", HttpStatus.OK);
	}
	
	@GetMapping("/find/{flightId}")
	public ResponseEntity<Object> findById(@PathVariable("flightId") int flightId)
	{
		return new ResponseEntity<>(flightservice.findById(flightId),HttpStatus.OK);
	}
	
}
