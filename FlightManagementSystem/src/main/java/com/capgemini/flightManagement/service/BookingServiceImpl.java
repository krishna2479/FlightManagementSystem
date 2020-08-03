package com.capgemini.flightManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightManagement.dao.BookingDao;
import com.capgemini.flightManagement.dto.Booking;
import com.capgemini.flightManagement.dto.Flight;
import com.capgemini.flightManagement.exception.BookingInvalidException;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookingdao;

	@Override
	public void addBooking(Booking booking) throws BookingInvalidException {
		
		//here implicitly giving the data for flight.class
		Flight flight =new Flight();
		flight.setCarrierName("Economy");
		flight.setFlightId(101);
//		flight.setFlightNumber(1001);
		flight.setSeatCapacity(200);
		flight.setFlightModel("A1234");
		booking.setFlight(flight);
		if(booking.getNoOfPassengers()>booking.getFlight().getSeatCapacity())
		{
			throw new BookingInvalidException("check details again");
		}
		bookingdao.addBooking(booking);
		
		
		
	}

	@Override
	public List<Booking> viewBooking() {
		// TODO Auto-generated method stub
		return bookingdao.viewBooking();
	}

	@Override
	public Booking FindById(Long bookingId) {
		// TODO Auto-generated method stub
		return bookingdao.findById(bookingId);
	}

	@Override
	public void cancelBooking(Long bookingId) {
		bookingdao.cancelBooking(bookingId);
		// TODO Auto-generated method stub
		
	}

}
