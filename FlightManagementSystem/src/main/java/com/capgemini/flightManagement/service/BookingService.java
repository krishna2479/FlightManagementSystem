package com.capgemini.flightManagement.service;

import java.util.List;

import com.capgemini.flightManagement.dto.Booking;

public interface BookingService {
	public void create(Booking booking);
	public List<Booking>retreive();
	public Booking FindById(Long bookingId);
	public void delete(Long bookingId);

}
