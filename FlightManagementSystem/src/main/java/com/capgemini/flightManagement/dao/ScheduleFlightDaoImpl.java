package com.capgemini.flightManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.flightManagement.dto.ScheduleFlight;
import com.capgemini.flightManagement.exception.ScheduleFlightException;
/*************************************************************************************************************************
 * @author Gaurav Vasasali 
 * Description : It is a dao implementation class, which has functionality of
 * 				 my  flight management functions and does the
 * 				 transactions with entity classes. using entity manager.
 *         Version 1.0 
 *         Created Date 31-JUL-2020
 *************************************************************************************************************************/
//@Transactional
@Repository
public class ScheduleFlightDaoImpl implements ScheduleFlightDao {
	
	@PersistenceContext
	 EntityManager em;
	
	@Override
	public List<ScheduleFlight> getAllSchedule() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from ScheduleFlight sf");
		return query.getResultList();
	}
	@Override
	public void addShedule(ScheduleFlight shedule)
	{
		em.persist(shedule);
	}
	@Override
	public void delete(int sheduleid)
	{
		ScheduleFlight schedule = em.find(ScheduleFlight.class,sheduleid );
		em.remove(schedule);
	}
	@Override
	public ScheduleFlight findById(int id) {
		return em.find(ScheduleFlight.class, id);
	}

	@Override
	public void update(int sheduleid,ScheduleFlight shedule) throws ScheduleFlightException {
		
		ScheduleFlight schflightobject=em.find(ScheduleFlight.class, sheduleid);
		if(schflightobject==null) { 
			throw new ScheduleFlightException("ScheduleFlightId not available to update");
		}
		else {
		schflightobject.setSCHEDULEFLIGHTID(shedule.getSCHEDULEFLIGHTID());
		schflightobject.setSourceAirport(shedule.getSourceAirport());
		schflightobject.setDestinationAirport(shedule.getDestinationAirport());
		schflightobject.setDepartureDate(shedule.getDepartureDate());
		schflightobject.setDepartureTime(shedule.getDepartureTime());
		schflightobject.setArrivalDate(shedule.getArrivalDate());
		schflightobject.setArrivalTime(shedule.getArrivalTime());
		schflightobject.setTicketCost(shedule.getTicketCost());
		em.persist(schflightobject);
		}
	}
	@Override
	public List<ScheduleFlight> getScheduleFlight(String source , String destination)
	{
		String jpql = "from SCHEDULE_TABLE1 s where s.SourceAirport=:sr and s.DestinationAirport=:ds";
		TypedQuery<ScheduleFlight> query = em.createQuery(jpql,ScheduleFlight.class);
		query.setParameter("sr", source);
		query.setParameter("ds", destination);
		return query.getResultList();
	}
	
}
