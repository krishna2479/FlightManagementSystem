package com.capgemini.flightManagement.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name="BookingDetail")
public class Booking {
	
	Booking()
	{
		
	}
	

	@Id
	//It will generate the value for bookingId in sequence 
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long BookingId;
	@Column @NotNull
	private String customerName;
	@Column @NotNull
	private double price;
	@Column @NotNull
	private Date bookingDate;
	@Column @NotNull
	private int noOfPassengers;
	
	// here it has many to one relationship like one flight can have multiple bookings
	@ManyToOne(targetEntity = Flight.class)
	@JoinColumn(name = "flightId",nullable = false)
	private Flight flight;
	
	
	/**
	 * @return the bookingId
	 */
	public Long getBookingId() {
		return BookingId;
	}
	
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Long bookingId) {
		BookingId = bookingId;
	}
	
	/**
	 * @return the CustomerName
	 */
	public String getName() {
		return customerName;
	}
	
	
	/**
	 * @param CustomerName the CustomerName to set
	 */
	public void setName(String name) {
		customerName = name;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}
	
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	/**
	 * @return the noOfPassengers
	 */
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	
	/**
	 * @param noOfPassengers the noOfPassengers to set
	 */
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	
	/**
	 * @return the Flight.class
	 */
	public Flight getFlight() {
		return flight;
	}
	
	/**
	 * @param flight the Flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
	public Booking(Long bookingId, String customerName, double price, Date bookingDate, int noOfPassengers,
			Flight flight) {
		super();
		BookingId = bookingId;
		this.customerName = customerName;
		this.price = price;
		this.bookingDate = bookingDate;
		this.noOfPassengers = noOfPassengers;
		this.flight = flight;
	}
	
	
}
	


