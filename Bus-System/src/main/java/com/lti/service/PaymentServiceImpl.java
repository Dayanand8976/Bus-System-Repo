package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BalanceStatus;
import com.lti.dto.UserPayment;
import com.lti.entity.Passenger;
import com.lti.entity.Wallet;
import com.lti.exception.WalletException;
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
			BalanceStatus bs = new BalanceStatus();
			Wallet wallet= new Wallet();
			userPayment.setTicketId((int)obj[0]);
			userPayment.setUserId((int)obj[1]);
			userPayment.setRouteFare((int)obj[2]);
			
			List<Passenger> passengers = walletRepo.getPassengersInSingleTicket(userPayment.getTicketId());
			int passengerCount = 0;
			int totalFare=0;
			for (Passenger p : passengers) {
				passengerCount++;
			}
			int a =5;
			int b= 10;
			totalFare= passengerCount * userPayment.getRouteFare();
			
			userPayment.setNoOfPassengers(passengerCount);
			userPayment.setTotalFare(totalFare);
			userPayment.setMessage("booked");
			userPayment.setStatus(true);
			userPay.add(userPayment);
		 }
		return userPay;
	}

	
}
