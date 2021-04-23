package com.lti.dto;

import java.time.LocalDate;
import java.util.List;


public class SearchBusStatus /*extends BusSeat*/ {
	
	private int id;
	private int busNo;
	private String name;
	private String busType;
	private LocalDate startDate;
	private  int fare;
	//private List<BusSeat> busSeats;
	//private int seatNo;
	private String source;
	private String destination;
	 
	public SearchBusStatus(int id, int busNo, String name, String busType, LocalDate startDate,
			int fare, /*List<BusSeat> busSeats,int seatNo, */String source, String destination)
	{
		super();
		this.id=id;
		this.busNo = busNo;
		this.name = name;
		this.busType = busType;
		this.startDate= startDate;
		this.fare= fare;
		//this.busSeats=busSeats;
		//this.seatNo=seatNo;
		this.source=source;
		this.destination=destination;
		
	}
	public SearchBusStatus()
	{
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	/*public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	public List<BusSeat> getBusSeats() {
		return busSeats;
	}
	public void setBusSeats(List<BusSeat> busSeats) {
		this.busSeats = busSeats;
	}*/
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
	

}
