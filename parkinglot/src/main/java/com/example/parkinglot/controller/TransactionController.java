package com.example.parkinglot.controller;

import com.example.parkinglot.service.TransactionService;

public class TransactionController {
	private TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
}
