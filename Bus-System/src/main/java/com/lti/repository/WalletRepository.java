package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import com.lti.entity.Passenger;
import com.lti.entity.Wallet;

public interface WalletRepository {

	public int fetchIdByEmail(String email);
	public List<Object[]> TotalFare (int UserId);
	//public void deleteWallet(int wid);
	public int fetchById(int uid);
	//public int addBalance(int wid);
}
