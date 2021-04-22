package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Balance;
import com.lti.dto.BalanceStatus;
import com.lti.dto.UserPayment;
import com.lti.entity.Wallet;
import com.lti.exception.WalletException;
import com.lti.service.PaymentService;
import com.lti.service.WalletService;
import com.lti.service.WalletServiceImp;

@RestController
@CrossOrigin
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/checkbalance")
	public BalanceStatus balance(@RequestBody Balance balance) {
		try {
			Wallet wallet = walletService.checkBalance(balance.getEmail());
			BalanceStatus balanceStatus = new BalanceStatus();
			balanceStatus.setStatus(true);
			balanceStatus.setMessage("Check your balance");
			balanceStatus.setUserId(wallet.getUser().getId());
			balanceStatus.setBalance(wallet.getBalance());
			return balanceStatus;
			
		}
		catch(WalletException e){
			BalanceStatus balanceStatus = new BalanceStatus();
			balanceStatus.setStatus(false);
			balanceStatus.setMessage(e.getMessage());
			return balanceStatus;
		}
	}
	
	@GetMapping("/routeFare")
	public List<UserPayment> showTotalFare(@RequestParam("id") int userId){
		return paymentService.showTotalFare(userId);
	}
	
	@PostMapping("/addBalance")
	public BalanceStatus updateBalance(@RequestBody Wallet wallet){
		try {
			Wallet w =walletService.updateBalance(wallet.getId(),wallet.getBalance());
			BalanceStatus balanceStatus = new BalanceStatus();
			balanceStatus.setWalletId(w.getId());
			balanceStatus.setBalance(w.getBalance());
			return balanceStatus;
		}
		catch(WalletException e) {
			BalanceStatus balanceStatus = new BalanceStatus();
			balanceStatus.setMessage(e.getMessage());
			return balanceStatus;
		}
	}
	
	@GetMapping("/deleteWallet")
	public String deleteWallet(@RequestParam("id") int id) {
		return walletService.deleteWallet(id);
	}
	
	
	
	
}
