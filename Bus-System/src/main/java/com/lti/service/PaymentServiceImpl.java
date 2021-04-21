package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.UserPayment;
import com.lti.repository.WalletRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private WalletRepository walletRepo;
	
	@Override
	public List<UserPayment> showTotalFare(int userId) {
		List<UserPayment> userPay = new ArrayList<UserPayment>();
		List<Object[]> list =walletRepo.TotalFare(userId);
		
		for(Object[] obj:list) {
			UserPayment userPayment= new UserPayment();
			userPayment.setTicketId((int)obj[0]);
			userPayment.setUserId((int)obj[1]);
			userPayment.setRouteFare((int)obj[2]);
			userPayment.setMessage("booked");
			
			userPay.add(userPayment);
		}
		return userPay;
		
		
	}

	
}
