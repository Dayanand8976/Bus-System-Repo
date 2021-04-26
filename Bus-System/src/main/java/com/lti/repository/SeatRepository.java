package com.lti.repository;

import com.lti.entity.Seat;

public interface SeatRepository {
	public Seat fetchSeat(String seatNo, int bNo);
}
