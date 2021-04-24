package com.lti.service;

import java.time.LocalDate;
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
import com.lti.repository.BookingRepository;
import com.lti.repository.WalletRepository;
import com.lti.repository.WalletRepositoryImpl;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private WalletRepositoryImpl walletRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private WalletService walletService;
	
	@Override
	public List<UserPayment> showDetails (int userId) {
		List<UserPayment> userPay = new ArrayList<UserPayment>();
		List<Object[]> list =walletRepo.TotalFare(userId);
		
		for(Object[] obj:list) {
			UserPayment userPayment= new UserPayment();
			userPayment.setTicketId((int)obj[0]);
			userPayment.setBusName((String)obj[1]);
			userPayment.setSource((String)obj[2]);
			userPayment.setDestination((String)obj[3]);
			userPayment.setDepatureDate((LocalDate)obj[4]);
			userPayment.setfName((String)obj[5]);
			userPayment.setlName((String)obj[6]);
			userPayment.setRouteFare((int)obj[7]);
			
			
			List<Passenger> passengers = bookingRepo.getPassengersInSingleTicket(userPayment.getTicketId());
			int passengerCount=0;
			String seatNo="";
			
			for (Passenger p : passengers) {
				passengerCount++;
				seatNo=" "+p.getSeat().getSeatNo();
			}
			int totalFare=(passengerCount*userPayment.getRouteFare())+(passengerCount*10);
					
			userPayment.setNoOfPassengers(passengerCount);
			userPayment.setSeatNo(seatNo);
			userPayment.setTotalFare(totalFare);
			
			userPay.add(userPayment);
		}
		
		return userPay;
	}

	
	
}
