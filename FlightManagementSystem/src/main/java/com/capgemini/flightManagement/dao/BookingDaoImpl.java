package com.capgemini.flightManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.Booking;

@Transactional
@Repository
public class BookingDaoImpl implements BookingDao {
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public void create(Booking booking) {
		entitymanager.persist(booking);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> retreive() {
		Query q = entitymanager.createQuery("from Booking s");
		return q.getResultList();
	}

	@Override
	public Booking findById(Long bookingId) {
		return entitymanager.find(Booking.class, bookingId);
		
	}

	@Override
	public void delete(Long bookingId) {
		Booking booking = entitymanager.find(Booking.class,bookingId);
		entitymanager.remove(booking);
	}

}
