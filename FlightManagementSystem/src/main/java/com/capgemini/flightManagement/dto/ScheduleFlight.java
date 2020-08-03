package com.capgemini.flightManagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "SCHEDULE_TABLE1")
public class ScheduleFlight {
	

	@Id
	@NotNull
	private int SCHEDULEFLIGHTID;
	@Column
	private String SourceAirport;
	@Column
	private String DestinationAirport;
	@Column
	private String DepartureDate;
	@Column
	private String DepartureTime;
	@Column
	private String ArrivalDate;
	@Column
	private String ArrivalTime;
	@Column
	private int TicketCost;
	@ManyToOne(targetEntity = Flight.class)
	@JoinColumn(name = "flightId")
	private Flight flight;
//	(name = "ScheduleFlightId")
//	(name = "SourceAirport")
//	(name = "DestinationAirport")
//	(name = "DepartureDate")
//	(name = "DepartureTime")
//	(name = "ArrivalDate")
//	(name = "ArrivalDate")
//	(name = "ArrivalTime")
//	(name = "TicketCost")
	public int getSCHEDULEFLIGHTID() {
		return SCHEDULEFLIGHTID;
	}
	public void setSCHEDULEFLIGHTID(int sCHEDULEFLIGHTID) {
		SCHEDULEFLIGHTID = sCHEDULEFLIGHTID;
	}
	public String getSourceAirport() {
		return SourceAirport;
	}
	public void setSourceAirport(String sourceAirport) {
		SourceAirport = sourceAirport;
	}
	public String getDestinationAirport() {
		return DestinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		DestinationAirport = destinationAirport;
	}
	public String getDepartureDate() {
		return DepartureDate;
	}
	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}
	public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
	public String getArrivalDate() {
		return ArrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		ArrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public int getTicketCost() {
		return TicketCost;
	}
	public void setTicketCost(int ticketCost) {
		TicketCost = ticketCost;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public ScheduleFlight(int sCHEDULEFLIGHTID, String sourceAirport, String destinationAirport, String departureDate,
			String departureTime, String arrivalDate, String arrivalTime, int ticketCost, Flight flight) {
		super();
		SCHEDULEFLIGHTID = sCHEDULEFLIGHTID;
		SourceAirport = sourceAirport;
		DestinationAirport = destinationAirport;
		DepartureDate = departureDate;
		DepartureTime = departureTime;
		ArrivalDate = arrivalDate;
		ArrivalTime = arrivalTime;
		TicketCost = ticketCost;
		//this.flight = flight;
	}
	public ScheduleFlight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
