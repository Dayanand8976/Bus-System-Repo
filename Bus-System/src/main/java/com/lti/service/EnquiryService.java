package com.lti.service;

import java.time.LocalDate;
import java.util.List;
import com.lti.dto.SearchBusStatus;
import com.lti.entity.Seat;


public interface EnquiryService {
	public List<SearchBusStatus> busEnquiry(String source, String destination, LocalDate startDate);
	public List<Seat> getSeatNumberList(int ttid);
	
	//public List<Object[]> searchBus(String source, String destination, LocalDate startDateTime);
	
	//public SearchBus busEnquiry(String source, String destination, LocalDate startDateTime);
	
	//public Object[] busEnquiry(String source, String destination);
}
