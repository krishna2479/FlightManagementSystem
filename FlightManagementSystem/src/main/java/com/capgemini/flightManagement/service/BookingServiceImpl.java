package com.capgemini.flightManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightManagement.dao.BookingDao;
import com.capgemini.flightManagement.dto.Booking;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookingdao;

	@Override
	public void create(Booking booking) {
		
		bookingdao.create(booking);
		
		
		
	}

	@Override
	public List<Booking> retreive() {
		// TODO Auto-generated method stub
		return bookingdao.retreive();
	}

	@Override
	public Booking FindById(Long bookingId) {
		// TODO Auto-generated method stub
		return bookingdao.findById(bookingId);
	}

	@Override
	public void delete(Long bookingId) {
		bookingdao.delete(bookingId);
		// TODO Auto-generated method stub
		
	}

}
