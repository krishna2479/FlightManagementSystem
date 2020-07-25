package com.capgemini.flightManagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="FlightTable")
public class Flight {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int flightId;
	
	
	@Column
	int flightNumber;
	
	
	@Column
	String flightModel;
	
	
	@Column
	String carrierName;
	
	
	@Column
	int seatCapacity;


	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}


	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	/**
	 * @return the flightNumber
	 */
	public int getFlightNumber() {
		return flightNumber;
	}


	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	/**
	 * @return the flightModel
	 */
	public String getFlightModel() {
		return flightModel;
	}


	/**
	 * @param flightModel the flightModel to set
	 */
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}


	/**
	 * @return the carrierName
	 */
	public String getCarrierName() {
		return carrierName;
	}


	/**
	 * @param carrierName the carrierName to set
	 */
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	/**
	 * @return the seatCapacity
	 */
	public int getSeatCapacity() {
		return seatCapacity;
	}


	/**
	 * @param seatCapacity the seatCapacity to set
	 */
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	
}
