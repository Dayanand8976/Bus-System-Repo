package com.lti.dto;

import com.lti.entity.Bus;

public class SearchBusStatus extends Status {
	
	private int busNo;
	private String name;
	private int totalSeats;
	private  int fare;
	
	private Bus bus;
	
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
	
	

}
