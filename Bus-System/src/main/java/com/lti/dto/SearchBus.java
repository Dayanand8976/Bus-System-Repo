package com.lti.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchBus {
	
	private int busNo;
	private String source;
	private String destination;
	
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private  LocalDate startDateTime;
	
	private int fare;
	
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
	public LocalDate getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDate startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	

}
