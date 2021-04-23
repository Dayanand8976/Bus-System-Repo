package com.lti.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


import com.lti.dto.SearchBusStatus;
import com.lti.entity.Seat;


@Repository
public class EnquiryRepositoryImpl extends GenericRepository implements EnquiryRepository {

	

	/*@Override
	public List<SearchBusStatus> busEnquiry(String source, String destination, LocalDate startDate) {
		
		try {
			
			String jpql="select new com.lti.dto.SearchBusStatus( tt.id,b.busNo ,b.name, b.busType, tt.startDate,r.fare, s.seatNo,r.source, r.destination)"+
						"from Timetable tt "+
						"join tt.route r "+
						"join tt.bus b "+
						"join b.seats s "+
						"where r.source= :sc and r.destination= :dest  and trunc(tt.startDate)= trunc(:ldt) and s.status='available'";
			
			Query q=entityManager.createQuery(jpql);
			q.setParameter("sc", source);
			q.setParameter("dest", destination);
			q.setParameter("ldt", startDate);
			return  q.getResultList();
			
	}
	catch(NoResultException e)
	{
		e.printStackTrace();
		return null;
	/*output: 
	[
    {"id": 904,"busNo": 403,"name": "Shivleela","busType": "ac","startDate": "2021-04-28","fare": 300,"seatNo": 1,"source": "Mumbai","destination": "Pune"},
    {"id": 904,"busNo": 403,"name": "Shivleela","busType": "ac","startDate": "2021-04-28","fare": 300,"seatNo": 2,"source": "Mumbai","destination": "Pune"},
    {"id": 904,"busNo": 403,"name": "Shivleela","busType": "ac","startDate": "2021-04-28","fare": 300,"seatNo": 4,"source": "Mumbai","destination": "Pune"},
    {"id": 904, "busNo": 403,"name": "Shivleela","busType": "ac","startDate": "2021-04-28","fare": 300,"seatNo": 5,"source": "Mumbai","destination": "Pune"},
    {"id": 901,"busNo": 401, "name": "Neeta","busType": "non-ac","startDate": "2021-04-28","fare": 300,"seatNo": 2,"source": "Mumbai","destination": "Pune" },
    { "id": 901,"busNo": 401,"name": "Neeta", "busType": "non-ac","startDate": "2021-04-28","fare": 300,"seatNo": 4,"source": "Mumbai","destination": "Pune"},
    { "id": 901,"busNo": 401,"name": "Neeta", "busType": "non-ac","startDate": "2021-04-28","fare": 300,"seatNo": 5,"source": "Mumbai","destination": "Pune"}
	]
	
	} */

	//code for fetching data without seats 
	@Override
	public List<SearchBusStatus> busEnquiry(String source, String destination, LocalDate startDate) {
		
		try {
			
			String jpql="select new com.lti.dto.SearchBusStatus( tt.id, b.busNo ,b.name, b.busType, tt.startDate,r.fare,r.source, r.destination)"+
						"from Timetable tt "+
						"join tt.route r "+
						"join tt.bus b "+
						"where r.source= :sc and r.destination= :dest  and trunc(tt.startDate)= trunc(:ldt) ";
			
			Query q=entityManager.createQuery(jpql);
			q.setParameter("sc", source);
			q.setParameter("dest", destination);
			q.setParameter("ldt", startDate);
			return  q.getResultList();
			
	}
	catch(NoResultException e)
	{
		e.printStackTrace();
		return null;
	}
	}
	/*output:[
    {"id": 904,"busNo": 403,"name": "Shivleela","busType": "ac","startDate": "2021-04-28","fare": 300,"source": "Mumbai","destination": "Pune"},
    {"id": 901,"busNo": 401,"name": "Neeta","busType": "non-ac","startDate": "2021-04-28","fare": 300,"source": "Mumbai","destination": "Pune"}
	]*/
	
	
	
	
	@Override
	public List<Seat> getSeatNumberList(int ttid) {
		String jpql="select s.id, s.seatNo, b.busNo from Seat s join s.bus b join b.timetable tt where tt.id= :ttid and s.status='available' ";
		Query q=entityManager.createQuery(jpql);
		q.setParameter("ttid", ttid);
		return q.getResultList(); 
		
		/*output:
		 * [
    			[ 116,1,403],
    			[117,2,403],
    			[119, 4,403],
    			[120,5,403]
			]*/
		
		
	}
	
	
	
}
//sql query
/*"select tt.timetable_id, tt.start_date, b.bus_no , b.bus_type, r.fare, s.seat_no, s.status"+
"from timetable tt inner join route r on tt.route_id=r.route_id"+
"inner join bus b on tt.bus_no = b.bus_no"+
"inner join seat s on s.bus_no = b.bus_no"+
"where r.source='Mumbai' and r.destination='Pune' and s.status='available' and tt.start_date='28-04-2021'";*/

	
	


