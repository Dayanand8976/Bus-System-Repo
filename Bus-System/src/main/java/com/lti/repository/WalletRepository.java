package com.lti.repository;

import java.util.List;

public interface WalletRepository {

	public int fetchIdByEmail(String email);
	public List<Object[]> TotalFare (int UserId);
	
}
