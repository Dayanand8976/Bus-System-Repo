package com.lti.service;

import java.util.List;

import com.lti.dto.TicketStatusConfirmation;
import com.lti.dto.UserTicket;
import com.lti.entity.Ticket;

public interface BookingService {

	public TicketStatusConfirmation bookTicket(TicketStatusConfirmation tsc);
	
	public TicketStatusConfirmation printBookedTicket(TicketStatusConfirmation tsc,int ticketId);

	public List<UserTicket> showAllTicketsOfUser(int userId);

	public Ticket getTicketById(int ticketId);

	public boolean deleteTicket(Ticket ticket);
}
