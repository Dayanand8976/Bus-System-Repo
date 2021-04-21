package com.lti.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.SearchBus;
import com.lti.dto.SearchBusStatus;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.exception.EnquiryServiceException;
import com.lti.service.EnquiryService;

@RestController
@CrossOrigin
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	
	@GetMapping(value = "/searchBus/{source}/{destination}/{date}",produces="application/json")
	public List<Object[]> searchBusAvailable(@PathVariable(value = "source") String source,
			@PathVariable(value = "destination") String destination, @PathVariable(value ="startDateTime") LocalDate startDateTime)
	{
		List<Object[]> list = null;
		try {
			list =enquiryService.searchBus(source, destination, startDateTime);
			}
		catch(EnquiryServiceException e)
		{
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	/*@PostMapping("/search")
	public List<SearchBus> busEnquiry( @RequestBody SearchBus searchBus)
	{
		return enquiryService.busEnquiry(searchBus.getSource(), searchBus.getDestination(), searchBus.getStartDateTime());
		
	}*/
	
	
	/*public List<SearchBus> busEnquiry(@RequestParam("source")String source,@RequestParam("destination")String destination,@RequestParam("startDateTime")LocalDateTime startDateTime) {
		return enquiryService.busEnquiry(source, destination, startDateTime);
	}*/
	
	
	
	
/*	@PostMapping("/search")
	public List<SearchBus> searchBus(@RequestBody SearchBus searchBus)
	{
		try
		{
			List<SearchBus> bus =  enquiryService.busEnquiry(searchBus.getSource(), searchBus.getDestination(), searchBus.getStartDateTime());
			return (List<SearchBus>) bus;
		}
		catch(EnquiryServiceException e)
		{
			SearchBusStatus status= new SearchBusStatus();
			 status.setMessage(e.getMessage());
			 return null;
			
			
		}
	}*/
	
	
	
	/*@PostMapping("/search")
	public Object[] searchBus(@RequestBody SearchBus searchBus)
	{
		try
		{
			Object[] obj = enquiryService.busEnquiry(searchBus.getSource(), searchBus.getDestination());
			return obj;
		}
		catch(EnquiryServiceException e)
		{
			e.getMessage();
			return null;
		}
	}*/

	
	
	/*public List<SearchBusResult> search(@RequestBody SearchBus searchBus)
	{
		try {
			List<SearchBusResult> bus = enquiryService.busEnquiry(searchBus.getSource(), searchBus.getDestination());
			//List<SearchBusResult> s = (List<SearchBusResult>) new SearchBusResult();
			Bus b = new Bus();
			Route r = new Route();
			s.setBusNo(b.getBusNo());
			s.setName(b.getName());
			s.setTotalSeats(b.getTotalSeats());
			s.setFare(r.getFare());
			
			return s;
		}
		
		
	}*/

}
