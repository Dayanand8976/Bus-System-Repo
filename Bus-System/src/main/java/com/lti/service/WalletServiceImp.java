package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.entity.Wallet;
import com.lti.exception.WalletException;
import com.lti.repository.WalletRepositoryImpl;

@Service
@Transactional
public class WalletServiceImp implements WalletService{
	
	@Autowired
	private WalletRepositoryImpl walletRepo;


	public Wallet checkbalance(String email) {
		try {
			int id= walletRepo.fetchIdByEmail(email);
			Wallet wallet = walletRepo.fetch(Wallet.class,id);
			return wallet;
		}
		catch(EmptyResultDataAccessException e) {
			throw new WalletException("No wallet for this email");
		}
	}
	
	
}
