package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.PaymentReciept;

public class PaymentRecieptRepository {
	private static long id;
	private HashMap<Long, PaymentReciept> repository;
	
	public PaymentRecieptRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public PaymentReciept findById(long id) {
		return repository.get(id);
	}
	
	public PaymentReciept save(PaymentReciept paymentReciept) {
		PaymentReciept PaymentReciept1 = findById(paymentReciept.getId());
		if(PaymentReciept1 != null) {
			repository.put(paymentReciept.getId(), paymentReciept);
			return paymentReciept;
		}else {
			paymentReciept.setId(++id);
			repository.put(paymentReciept.getId(), paymentReciept);
			return paymentReciept;
		}
	}
	
	public PaymentReciept deleteById(long id) {
		return repository.remove(id);
	}
}
