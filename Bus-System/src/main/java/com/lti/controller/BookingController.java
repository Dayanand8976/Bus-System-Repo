package com.lti.controller;

//
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TicketStatusConfirmation;
import com.lti.dto.UserTicket;
import com.lti.entity.Ticket;
import com.lti.service.BookingService;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/*
	 * @PostMapping(path="/bookTicket") public Status reserveSeat(@RequestBody
	 * TicketStatusConfirmation tsc) { bookingService.bookTicket(tsc); Status status
	 * = new Status(); status.setMessage("Ticket booked successfully"); return
	 * status ; }
	 */

	@PostMapping(path = "/bookTicket" , consumes = "application/json")
	public TicketStatusConfirmation reserveSeat(@RequestBody TicketStatusConfirmation tsc) {
		System.out.println(tsc);
		return bookingService.bookTicket(tsc);

	}

	// show all tickets booked by single user by userId
	@GetMapping("/showAllTickets")
	public List<UserTicket> showAllTicketsOfUser(@RequestParam("id") int userId) {

		return bookingService.showAllTicketsOfUser(userId);
	}

	@GetMapping("/showTicket")
	public Ticket getTicketById(@RequestParam("id") int ticketId) {
		
		return bookingService.getTicketById(ticketId);
	}

	@DeleteMapping("/deleteTicket")
	public boolean deleteTicket(@RequestParam("id") int ticketId) {
		boolean Record = false;

		Ticket ticket = bookingService.getTicketById(ticketId);
		Record = bookingService.deleteTicket(ticket);

		return Record;

	}
}
