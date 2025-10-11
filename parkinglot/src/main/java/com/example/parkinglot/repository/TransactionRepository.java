package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.Transaction;

public class TransactionRepository {
	private static long id;
	private HashMap<Long, Transaction> repository;
	
	public TransactionRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public Transaction findById(long txnId) {
		return repository.get(txnId);
	}
	
	public Transaction save(Transaction txn) {
		Transaction txn1 = findById(txn.getId());
		if(txn1 != null) {
			repository.put(txn.getId(), txn);
			return txn;
		}else {
			txn.setId(++id);
			repository.put(txn.getId(), txn);
			return txn;
		}
	}
	
	public Transaction deleteById(long txnId) {
		return repository.remove(txnId);
	}
}
