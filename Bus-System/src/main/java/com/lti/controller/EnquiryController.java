package com.lti.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.SearchBusStatus;
import com.lti.dto.Status;

import com.lti.entity.Seat;
import com.lti.exception.EnquiryServiceException;
import com.lti.service.EnquiryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	
	@GetMapping("/searchBusStaus")
	public List<SearchBusStatus> fetchAllBus(@RequestParam("source")String source,@RequestParam("destination")String destination,
			@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate)
	{
		
		try {
			//Status s =new Status();
			List<SearchBusStatus> sb= enquiryService.busEnquiry(source, destination, startDate);
			return sb;
			
		}
		catch(EnquiryServiceException e)
			{
				List<SearchBusStatus> sb = null;
				//Status s =new Status();
				return null;
				
			}
		}
		
	

	@GetMapping("/getSeatList")
	public List<Seat> getSeatlist(@RequestParam("ttid")int ttid)
	{
		return enquiryService.getSeatNumberList(ttid);
		
	}
	
}

	
	
	
	


	
	/*@PostMapping("/search")
	public List<SearchBus> busEnquiry( @RequestBody SearchBus searchBus)
	{
		return enquiryService.busEnquiry(searchBus.getSource(), searchBus.getDestination(), searchBus.getStartDateTime());
		
	}*/
	
	
	
	
	
	

	
	
	


	
	
	
		
		
	


