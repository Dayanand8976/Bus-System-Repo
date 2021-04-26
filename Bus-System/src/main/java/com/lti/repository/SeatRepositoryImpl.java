package com.lti.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Seat;

@Repository
public class SeatRepositoryImpl extends GenericRepository implements SeatRepository {

	public Seat fetchSeat(String seatNo, int bNo) {

		String jpql = " select s from Seat s  where s.seatNo = :sn and s.bus.busNo = :bn";

		Query q = entityManager.createQuery(jpql);
		q.setParameter("sn", Integer.parseInt(seatNo));
		q.setParameter("bn", bNo);

		Seat seat = (Seat) q.getSingleResult();
		return seat;

	}
}
