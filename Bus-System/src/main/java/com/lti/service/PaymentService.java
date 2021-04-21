package com.lti.service;

import java.util.List;

import com.lti.dto.UserPayment;

public interface PaymentService {

	public List<UserPayment> showTotalFare(int userId);
}
