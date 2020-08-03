package com.capgemini.flightManagement.service;

import java.util.List;

import com.capgemini.flightManagement.dto.Booking;
import com.capgemini.flightManagement.exception.BookingInvalidException;

public interface BookingService {
	public void addBooking(Booking booking) throws BookingInvalidException;
	public List<Booking>viewBooking();
	public Booking FindById(Long bookingId);
	public void cancelBooking(Long bookingId);

}
