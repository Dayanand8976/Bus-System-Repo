package com.lti.dto;

import java.time.LocalDate;

public class UserPayment {

	private String busName;
	private String source;
	private String destination;
	private LocalDate depatureDate;
	private int TicketId;
	private String SeatNo;
	private int noOfPassengers;
	private String fName;
	private String lName;
	private int routeFare;
	private int totalFare;
	
	
	
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDepatureDate() {
		return depatureDate;
	}
	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}
	public int getTicketId() {
		return TicketId;
	}
	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}
	public String getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public int getRouteFare() {
		return routeFare;
	}
	public void setRouteFare(int routeFare) {
		this.routeFare = routeFare;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	
	
	

	
	
	
	
}
