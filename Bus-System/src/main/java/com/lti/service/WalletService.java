package com.lti.service;

import java.util.List;

import com.lti.dto.BalanceStatus;
import com.lti.entity.Wallet;

public interface WalletService {

	public Wallet checkbalance(String email);
	public BalanceStatus updatebalance(int id,int bal);
	
}
