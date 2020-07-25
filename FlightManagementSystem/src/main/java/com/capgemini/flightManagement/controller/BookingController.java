package com.capgemini.flightManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightManagement.dto.Booking;
import com.capgemini.flightManagement.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	@PostMapping(value="/booking/add",consumes={"application/json"})
	public String addBooking(@RequestBody Booking booking)
	{
		bookingservice.create(booking);
		return "Booking created";
	}
	
	
	@GetMapping(value="/booking")
	public List<Booking>FetchBooking()
	{
		 return bookingservice.retreive();
		
	}
	
	
	@DeleteMapping(value="/booking/delete/{id}")
	public String deleteBooking(@PathVariable Long id)
	{
		System.out.println(id);
		Booking booking = bookingservice.FindById(id);
		bookingservice.delete(id);
		return "Booking cancelled";
	}
	

}
