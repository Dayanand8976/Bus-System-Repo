package com.lti.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.lti.dto.SearchBus;
import com.lti.entity.Bus;

public interface EnquiryRepository  {
	
	//public abstract List<Object[]> searchBus(String source,String destination,LocalDate startDateTime) ;
	
	public List<SearchBus> busEnquiry(String source , String destination , LocalDate startDate);
	
	//public List<Bus> busEnquiry(String source , String destination , LocalDateTime startDateTime);
	//public Object[] busEnquiry(String source , String destination);

}
