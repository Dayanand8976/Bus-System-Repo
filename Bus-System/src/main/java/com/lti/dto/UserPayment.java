package com.lti.dto;

public class UserPayment  extends Status{

	private int ticketId;
	private int UserId;
	private int routeFare;
	private int noOfPassengers;
	private int totalFare;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getRouteFare() {
		return routeFare;
	}
	public void setRouteFare(int routeFare) {
		this.routeFare = routeFare;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	
	
}
