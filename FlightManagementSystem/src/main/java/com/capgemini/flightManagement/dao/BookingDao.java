package com.capgemini.flightManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.Booking;

@Repository
public interface BookingDao {
	public void addBooking(Booking booking);

	public List<Booking> viewBooking();
	public Booking findById(Long bookingId);
	
	public void cancelBooking(Long bookingId);

}
