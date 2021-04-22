package com.lti.service;

import java.util.List;

import com.lti.dto.BalanceStatus;
import com.lti.entity.Wallet;

public interface WalletService {

	public Wallet checkBalance(String email);
	public Wallet updateBalance(int id,int bal);
	public String deleteWallet(int id);
	
}
