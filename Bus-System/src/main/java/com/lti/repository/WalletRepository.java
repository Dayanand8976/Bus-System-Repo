package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import com.lti.entity.Passenger;
import com.lti.entity.Wallet;

public interface WalletRepository {

	public int fetchIdByEmail(String email);
	public List<Object[]> TotalFare (int UserId);
	public List<Passenger> getPassengersInSingleTicket(int ticketId);
	public Wallet viewWallet(int id);
}
