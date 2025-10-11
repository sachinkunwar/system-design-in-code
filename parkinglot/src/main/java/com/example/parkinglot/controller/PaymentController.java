package com.example.parkinglot.controller;

import com.example.parkinglot.model.Bill;
import com.example.parkinglot.model.PaymentReciept;
import com.example.parkinglot.service.PaymentService;

public class PaymentController {
	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public PaymentReciept pay(Bill bill) {
		return paymentService.pay(bill);
	}
}
