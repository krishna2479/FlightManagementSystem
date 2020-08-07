package com.capgemini.flightManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.flightManagement.dto.ScheduleFlight;
import com.capgemini.flightManagement.exception.ScheduleFlightException;

@Repository
public interface ScheduleFlightDao {
	public void addShedule(ScheduleFlight shedule);
	public void delete(int sheduleid);
	public ScheduleFlight findById(int id);
	public void update(int sheduleid,ScheduleFlight shedule) throws ScheduleFlightException;
	public List<ScheduleFlight> getScheduleFlight(String source , String destination);
	public List<ScheduleFlight> getAllSchedule();

}