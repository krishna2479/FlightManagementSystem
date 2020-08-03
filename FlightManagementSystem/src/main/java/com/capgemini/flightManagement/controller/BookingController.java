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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightManagement.dto.Booking;
import com.capgemini.flightManagement.exception.BookingDetailsNotFoundException;
import com.capgemini.flightManagement.exception.BookingInvalidException;
import com.capgemini.flightManagement.service.BookingService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	@PostMapping(value="/booking/add",consumes={"application/json"})
	
	public ResponseEntity<Object> addBooking(@RequestBody Booking booking) throws BookingInvalidException
	{
		if(booking.getNoOfPassengers()<=0)
		{
				throw new BookingInvalidException("check the detaials again");
		}
		bookingservice.addBooking(booking);
		return new ResponseEntity<>("booking added ",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/booking")
	public  ResponseEntity<Object> viewBooking() throws BookingDetailsNotFoundException
	{
		List<Booking>booking = bookingservice.viewBooking();
		if(booking!=null)
		{
			return new ResponseEntity<>(bookingservice.viewBooking(),HttpStatus.OK);
		}
		else
		{
			throw new BookingDetailsNotFoundException("you haven't booked any ticket yet");
		}
		 
		
	}
	
	
	@DeleteMapping(value="/booking/delete/{id}")
	public ResponseEntity<Object> deleteBooking(@PathVariable Long id) throws BookingDetailsNotFoundException
	{
		Booking booking = bookingservice.FindById(id);
		if(booking!=null)
		{
		
			bookingservice.cancelBooking(id);
			
			return new ResponseEntity<>("booking cancelled ",HttpStatus.OK);
		}
		else
		{
			
			throw new BookingDetailsNotFoundException("your id didn't exist ");
			
		}
		
		
		
	}
	

}
