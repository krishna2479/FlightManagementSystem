package com.capgemini.flightManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.flightManagement.dao.FlightDaoImpl;
import com.capgemini.flightManagement.dto.Flight;
import com.capgemini.flightManagement.exception.FlightNotFoundException;
import com.capgemini.flightManagement.service.FlightServiceImpl;

@SpringBootTest
class FlightManagementSystemApplicationTests {
	
	Flight flight;

	@Autowired
	FlightDaoImpl dao;
	
	@Autowired
	FlightServiceImpl service;
	
	@Test
	public void TC_1(){
		assertEquals("Air India",service.findById(1).getCarrierName());
	}

	@Test
	void TC_2() {
		assertThrows(FlightNotFoundException.class,()->{service.findById(55);});
	}
	
	@Test
	void TC_3() {
		assertThrows(FlightNotFoundException.class,()->{service.deleteFlight(45);});
	}
	
	@Test
	void TC_4() {
		assertEquals(120, service.findById(101).getSeatCapacity());
	}
	
	@Test
	void TC_5() {
		assertThrows(FlightNotFoundException.class,()->{service.updateFlight(45, flight);});
	}
	
	@Test
	void TC_6() {
		assertThrows(Exception.class,()->{service.addFlight(flight);});
	}
	
	@Test
	void contextLoads() {
	}

}
