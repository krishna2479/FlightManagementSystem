package com.capgemini.flightManagement.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightManagement.dto.ScheduleFlight;
import com.capgemini.flightManagement.exception.ScheduleFlightException;
import com.capgemini.flightManagement.service.ScheduleFlightService;
/**************************************************************************************************
 *          @author         Gaurav Vasasali
 *          Description      It is a controller class having Request , Post , Delete,
 *          				 Put Mapping functions for functionalities of add schedules,delete, 
 *          				 update schedules and search schedules for the available flights.
 *          Version             1.0
 *          Created Date    31-JUL-2020
 **************************************************************************************************/
@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class ScheduleFlightController {
	
	@Autowired
	ScheduleFlightService service;
	@CrossOrigin
	@PostMapping(value="/addScheduleFlight",consumes={"application/json"})
	public ResponseEntity<Object> addScheduleFlight(@RequestBody ScheduleFlight schflight)
	{
		service.addSchFlight(schflight);
		return new ResponseEntity<>("Schedule added Successfull",HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping ("/SearchScheduleFlightById/{id}")
	public ResponseEntity<Object> searchScheduleFlightById(@PathVariable Integer id) 
	{
		return new ResponseEntity<>(service.schByid(id),HttpStatus.OK);
		
	}
	@CrossOrigin
	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<Object> deleteSchFlight(@PathVariable int id)
	{
		ScheduleFlight del = service.schByid(id);
		service.delete(id);
		return new ResponseEntity<>("Schedule deleted Successfully", HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping ("/updateSchFlight/{sflightId}")
	public ResponseEntity<Object> updateFlight(@PathVariable("sflightId") int sflightId,@RequestBody ScheduleFlight sflight) throws ScheduleFlightException
	{
		
	    service.updateSchFlight(sflightId, sflight);
	    return new ResponseEntity<>("Flight Updated SuccessFully", HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping (path="/ScheduleFlight/{sr}/{des}",method= RequestMethod.GET)
	public List<ScheduleFlight> searchScheduleFlight(@PathVariable String sr,@PathVariable String des)
	{
		List<ScheduleFlight> sf= service.getSchFLight(sr, des);
		return sf;
		
		}
	@CrossOrigin
	@GetMapping("/getScheduleAllFlight")
	public ResponseEntity<Object> viewAllFlight()
	{
		return new ResponseEntity<>(service.getAllSchedule(),HttpStatus.OK);
	}
	

}
