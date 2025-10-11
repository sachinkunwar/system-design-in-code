package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.Bill;

public class BillRepository {
	private static long id;
	private HashMap<Long, Bill> repository;
	
	public BillRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public Bill findById(long id) {
		return repository.get(id);
	}
	
	public Bill save(Bill bill) {
		Bill bill1 = findById(bill.getId());
		if(bill1 != null) {
			repository.put(bill.getId(), bill);
			return bill;
		}else {
			bill.setId(++id);
			repository.put(bill.getId(), bill);
			return bill;
		}
	}
	
	public Bill deleteById(long id) {
		return repository.remove(id);
	}
}
