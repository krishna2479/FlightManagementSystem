package com.capgemini.flightManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.Booking;

@Repository
public interface BookingDao {
	public void create(Booking booking);

	public List<Booking> retreive();
	public Booking findById(Long bookingId);
	
	public void delete(Long bookingId);

}
