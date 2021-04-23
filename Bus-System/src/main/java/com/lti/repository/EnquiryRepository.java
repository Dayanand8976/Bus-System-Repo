package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.SearchBusStatus;
import com.lti.entity.Seat;


public interface EnquiryRepository  {
	
	
	public List<SearchBusStatus> busEnquiry(String source , String destination , LocalDate startDate);
	public List<Seat> getSeatNumberList(int ttid); 
	
	
	
	//public abstract List<Object[]> searchBus(String source,String destination,LocalDate startDateTime) ;
	//public List<Bus> busEnquiry(String source , String destination , LocalDateTime startDateTime);
	

}
