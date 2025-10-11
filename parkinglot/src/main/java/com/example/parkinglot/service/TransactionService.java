package com.example.parkinglot.service;

import java.time.LocalDateTime;

import com.example.parkinglot.model.Transaction;
import com.example.parkinglot.model.constant.TransactionStatus;
import com.example.parkinglot.repository.TransactionRepository;

public class TransactionService {
	private TransactionRepository transactionRepository;
	
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public Transaction makeTransaction(Transaction txn) {
		txn.setStatus(TransactionStatus.SUCCESS);
		txn.setTime(LocalDateTime.now());
		return transactionRepository.save(txn);
	}
}
