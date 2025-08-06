package com.hexaware.hotpot.service;

import com.hexaware.hotpot.entities.Payment;

public interface IPaymentService {
	public Payment makePayment(Payment payment);
	public Payment getPaymentById(int paymentId);
	public String updateStatus(int paymentId);

}
