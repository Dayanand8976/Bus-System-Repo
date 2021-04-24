package com.lti.service;

import java.util.List;

import com.lti.dto.BalanceStatus;
import com.lti.entity.Wallet;

public interface WalletService {

	public Wallet checkBalance(String email);
	public Wallet addBalance(int wid,int bal);
	public int refundBalance(int id,int wid);
	/*public String deleteWallet(int id);*/
	public int subBalance(int uid,int wid);
	
	
	
}
