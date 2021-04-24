package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.dto.BalanceStatus;
import com.lti.dto.UserPayment;
import com.lti.entity.Wallet;
import com.lti.exception.WalletException;
import com.lti.repository.WalletRepositoryImpl;

@Service
@Transactional
public class WalletServiceImp implements WalletService{
	
	@Autowired
	private WalletRepositoryImpl walletRepo;
	
	@Autowired
	private PaymentService payService;
	
	
    @Override
	public Wallet checkBalance(String email) {
    	int id= walletRepo.fetchIdByEmail(email);
		Wallet wallet = walletRepo.fetch(Wallet.class,id);
		return wallet;
		}
	
	/*@Override
	public String deleteWallet(int id) {
		walletRepo.fetch(Wallet.class, id);
        walletRepo.deleteWallet(id);
		return "Deleted" ;
	}*/


	@Override
	public int subBalance(int uid,int wid) {
		Wallet wallet=walletRepo.fetch(Wallet.class, wid);
		int balance =walletRepo.fetchById(uid);
		int b=payService.showDetails(uid).get(0).getTotalFare();
		if(balance>=b) {
			wallet.setBalance(balance-b);
		}
	   // wallet.setBalance(wallet.getBalance()-bal);
		walletRepo.save(wallet);
		return wallet.getBalance();
	}


	@Override
	public int refundBalance(int id,int wid) {
		Wallet wallet=walletRepo.fetch(Wallet.class, wid);
		int balance =walletRepo.fetchById(id);
		int b=payService.showDetails(id).get(0).getTotalFare();
		LocalDate refund =payService.showDetails(id).get(0).getDepatureDate();
		if(LocalDate.now().compareTo(refund)<0) {
			wallet.setBalance(balance + (b/2));
		}
		walletRepo.save(wallet);
		return wallet.getBalance();
	}

	@Override
	public Wallet addBalance(int wid,int bal) {
		Wallet wallet = walletRepo.fetch(Wallet.class,wid);
		wallet.setBalance(wallet.getBalance()+bal);
		walletRepo.save(wallet);
		return wallet;
	}

	
}
