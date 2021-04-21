package com.lti.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.lti.dto.SearchBus;
import com.lti.dto.SearchBusStatus;
import com.lti.entity.Bus;

public interface EnquiryService {
	public List<SearchBus> busEnquiry(String source, String destination, LocalDate startDate);
	
	//public List<Object[]> searchBus(String source, String destination, LocalDate startDateTime);
	
	//public SearchBus busEnquiry(String source, String destination, LocalDate startDateTime);
	
	//public Object[] busEnquiry(String source, String destination);
}
