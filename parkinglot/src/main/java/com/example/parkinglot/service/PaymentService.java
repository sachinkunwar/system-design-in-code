package com.example.parkinglot.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.parkinglot.model.Bill;
import com.example.parkinglot.model.PaymentReciept;
import com.example.parkinglot.model.Transaction;
import com.example.parkinglot.model.constant.TransactionMode;
import com.example.parkinglot.repository.PaymentRecieptRepository;

public class PaymentService {
	private PaymentRecieptRepository paymentRecieptRepository;
	private TransactionService transactionService;
	
	public PaymentService(PaymentRecieptRepository paymentRecieptRepository, TransactionService transactionService) {
		this.paymentRecieptRepository = paymentRecieptRepository;
		this.transactionService = transactionService;
	}

	public PaymentReciept pay(Bill bill) {
		PaymentReciept paymentReciept = new PaymentReciept();
		paymentReciept.setAmount(bill.getAmount());
		Transaction  txn = new Transaction();
		txn.setAmount(bill.getAmount());
		txn.setMode(TransactionMode.CASH);
		
		txn = transactionService.makeTransaction(txn);
		
		paymentReciept.setTransactions(List.of(txn));
		paymentReciept.setTime(LocalDateTime.now());
		paymentRecieptRepository.save(paymentReciept);
		
		return paymentReciept;
	}
}
