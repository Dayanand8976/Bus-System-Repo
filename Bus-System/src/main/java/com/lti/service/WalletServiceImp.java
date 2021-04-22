package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.dto.BalanceStatus;
import com.lti.entity.Wallet;
import com.lti.exception.WalletException;
import com.lti.repository.WalletRepositoryImpl;

@Service
@Transactional
public class WalletServiceImp implements WalletService{
	
	@Autowired
	private WalletRepositoryImpl walletRepo;
	
    @Override
	public Wallet checkBalance(String email) {
    	int id= walletRepo.fetchIdByEmail(email);
		Wallet wallet = walletRepo.fetch(Wallet.class,id);
		return wallet;
		}


	@Override
	public Wallet updateBalance(int id,int bal) {
		Wallet wallet = walletRepo.fetch(Wallet.class, id);
		//walletRepo.viewWallet(id, bal);
		wallet.setBalance(wallet.getBalance()+bal);
		walletRepo.save(wallet);
		return wallet;
		
	}


	@Override
	public String deleteWallet(int id) {
		walletRepo.fetch(Wallet.class, id);
        walletRepo.deleteWallet(id);
		return "Deleted" ;
	}

}
