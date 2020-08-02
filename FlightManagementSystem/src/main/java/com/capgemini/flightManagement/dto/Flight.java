package com.capgemini.flightManagement.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FlightTable")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int flightId;
	
	@NotNull(message="flight model cannot be null")
	@Size(min=5,max=5,message="flight model must be of 5 characters")
	String flightModel;
	
	@NotNull(message="carrier name cannot be null")
	@Size(min=4,max=14,message="carrier name must be between 4 and 14 characters")
	String carrierName;
	
	@NotNull(message="seat capacity cannot be null")
//	@Min(value = 100, message = "minimum seat capacity should be 100")
//	@Max(value=200, message = "maximum seat capacity should not exceeds 200")
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
