package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.SearchBus;
import com.lti.dto.SearchBusStatus;
import com.lti.entity.Bus;
import com.lti.exception.EnquiryServiceException;
import com.lti.repository.EnquiryRepository;

@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService  {
	
	@Autowired 
	private EnquiryRepository enquiryRepository;

	

	@Override 
	public List<SearchBus> busEnquiry(String source, String destination, LocalDate startDate) {
		
		try {
			return enquiryRepository.busEnquiry(source, destination,startDate );
			
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new EnquiryServiceException("Sorry! No Bus Available");
		}
	}



	
	
	
	
	
	
	/*@Override
	public List<Object[]> searchBus(String source, String destination, LocalDate startDateTime) {
		
		return enquiryRepository.searchBus(source, destination, startDateTime);
	}*/

	/*@Override
	public List<SearchBus> busEnquiry(String source, String destination, LocalDateTime startDateTime) {
		List<SearchBus> searchBuses = new ArrayList<SearchBus>();
		
		List<Object[]> list = enquiryRepository.busEnquiry(source, destination, startDateTime);
		
		for(Object[] obj : list)
		{
			SearchBus searchBus = new SearchBus();
			searchBus.setBusNo((int)obj[0]);
			searchBus.setSource((String)obj[1]);
			searchBus.setDestination((String) obj[2]);
			searchBus.setStartDateTime((LocalDateTime) obj[3]);
			searchBus.setFare((int)obj[4]);
			searchBuses.add(searchBus);
			
			
		}
		
		return searchBuses;
		
		
		
		
		
	}*/

	/*@Override
	public Object[] busEnquiry(String source, String destination) {
		
		try {
			Object[] obj  = (Object[]) enquiryRepository.busEnquiry(source, destination);
			return obj;
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new EnquiryServiceException("No result found");
		}
		
	
	}*/


}
