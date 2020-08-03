package com.capgemini.flightManagement.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightManagement.dao.ScheduleFlightDao;
import com.capgemini.flightManagement.dto.ScheduleFlight;
import com.capgemini.flightManagement.exception.ScheduleFlightException;

/************************************************************************************
 *          @author          Gaurav Vasasali
 *          Description      It is a flight management service class that provides 
 *         					 the services for adding deleting searching and updating 
 *         					 the scheduling for the flights.	
 *          Version          2.0
 *          Created Date     31-JUL-2020
 ************************************************************************************/
@Transactional
@Service
public class ScheduleFlightServiceImpl implements ScheduleFlightService {
	
	@Autowired
	ScheduleFlightDao dao;
	
	/************************************************************************************
	 *          Method: addSchFlight(SheduleFlight)
	 *          Description: To add a schedule for a particular flight available.	
	 *          @param SheduleFlight - SheduleFlight class type object.
	 *          @returns - void. 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 31-JUL-2020                           
	 ************************************************************************************/	
	@Override
	public void addSchFlight(ScheduleFlight schflight)
	{
		dao.addShedule(schflight);
	}
	/************************************************************************************
	 *          Method: delete(scheduleId)
	 *          Description: To delete a schedule for a particular flight available.	
	 *          @param scheduleId - scheduleId of Schedule Flight.
	 *          @returns - void. 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 31-JUL-2020                           
	 ************************************************************************************/
	@Override
	public void delete(int schid)
	{
		dao.delete(schid);
	}
	/************************************************************************************
	 *          Method: schByid(scheduleId)
	 *          Description: To search a schedule for a particular flight by schedule Id.	
	 *          @param scheduleId - scheduleId of Schedule Flight.
	 *          @returns SheduleFlight - returns shedule details for a flight. 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 31-JUL-2020                           
	 ************************************************************************************/
	@Override
	public ScheduleFlight schByid(int id)
	{
		return dao.findById(id);
	}
	/************************************************************************************
	 *          Method: updateSchFlight(scheduleId,SheduleFlight)
	 *          Description: To update a schedule for a particular flight by schedule Id.	
	 *          @param scheduleId,SheduleFlight - scheduleId of Schedule Flight and
	 *          								  SheduleFlight object.
	 *          @returns - void 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 31-JUL-2020                           
	 ************************************************************************************/
	@Override
	public void updateSchFlight(int id,ScheduleFlight sflight) throws ScheduleFlightException
	{
		dao.update(id, sflight);
	}
	/************************************************************************************
	 *          Method: getSchFLight(sourceAirport,destinationAirport)
	 *          Description: To search a schedule for a particular flight by source
	 *          			  and destination airports.	
	 *          @param sourceAirport,destinationAirport -  source and destination airports
	 *          									        of Schedule Flight.
	 *          @returns List<SheduleFlight> - returns shedule details for the flights seached. 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 31-JUL-2020                           
	 ************************************************************************************/
	@Override
	public List<ScheduleFlight> getSchFLight(String sorce , String dest)
	{
		return dao.getScheduleFlight(sorce, dest);
	}
	@Override
	public List<ScheduleFlight> getAllSchedule() {
		// TODO Auto-generated method stub
		return dao.getAllSchedule();
	}
	

}
