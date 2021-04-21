package com.lti.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.dto.SearchBus;
import com.lti.entity.Bus;

@Repository
public class EnquiryRepositoryImpl extends GenericRepository implements EnquiryRepository {

	@Override
	public List<Object[]> searchBus(String source, String destination, LocalDate startDateTime) {
		
		String jpql = "select b.busNo,b.name,r.fare,t.startDateTime from Bus b  join b.route r  join b.timetable t where r.source= :sc and r.destination= :dest and trunc(t.startDateTime)= trunc(:ldt)";
		
		Query q=entityManager.createQuery(jpql);
		q.setParameter("sc", source);
		q.setParameter("dest", destination);
		q.setParameter("ldt",startDateTime );
		
		List<Object[]> list=q.getResultList();
		return list;
		
		
	}

	/*@Override
	//public List busEnquiry(String source, String destination, LocalDate startDateTime) {
	public List<SearchBus> busEnquiry(String source, String destination, LocalDate startDateTime) {
		
		try {
			
			String jpql = "select b.busNo,b.name,r.fare,t.startDateTime from Bus b  join b.route r  join b.timetable t where r.source= :sc and r.destination= :dest and trunc(t.startDateTime)= trunc(:ldt)";
			
			Query q=entityManager.createQuery(jpql);
			q.setParameter("sc", source);
			q.setParameter("dest", destination);
//			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			String ldt = dt.format(startDateTime);
//			LocalDate sdt = startDateTime.toLocalDate();
	//		LocalDateTime localDateTime1 = sdt.atStartOfDay();
//			String sdt = startDateTime.toString().substring(0, 8);
//			System.out.println("local date is"+ sdt);
			q.setParameter("ldt", startDateTime);
			System.out.println(q.getResultList().toString());
			
			return  q.getResultList();
			//List<Bus> obj =  q.getResultList();
			//Object[] obj = (Object[]) q.getSingleResult();
			//System.out.println(obj.getClass());
	
			//return obj ;
	}
	catch(NoResultException e)
	{
		e.printStackTrace();
		return null;
	}*/
	}

	
	
	
	
	
	
	
	
	
	
	

/*	@Override
	public List<Bus> busEnquiry(String source, String destination,LocalDateTime startDateTime) {
		try {
			
				String jpql = "select b.busNo,b.name,r.fare,t.startDateTime from Bus b  join b.route r  join b.timetable t where r.source= :sc and r.destination= :dest and trunc(t.startDateTime)= trunc(:ldt)";
				Query q=entityManager.createQuery(jpql);
				q.setParameter("sc", source);
				q.setParameter("dest", destination);
				q.setParameter("ldt", startDateTime);
				System.out.println(q.getResultList().toString());
				List<Bus> obj =  q.getResultList();
				//Object[] obj = (Object[]) q.getSingleResult();
				System.out.println(obj.getClass());
		
				return obj ;
		}
		catch(NoResultException e)
		{
			e.printStackTrace();
			return null;
		}
	}*/


