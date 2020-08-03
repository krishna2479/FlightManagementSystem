package com.capgemini.flightManagement.service;

import java.util.List;

import com.capgemini.flightManagement.dto.ScheduleFlight;
import com.capgemini.flightManagement.exception.ScheduleFlightException;

public interface ScheduleFlightService {
	public void addSchFlight(ScheduleFlight flight);
	public void delete(int schid);
	public ScheduleFlight schByid(int id);
	public void updateSchFlight(int id,ScheduleFlight sflight) throws ScheduleFlightException;
	public List<ScheduleFlight> getSchFLight(String sorce, String dest);
	public List<ScheduleFlight> getAllSchedule();

}
