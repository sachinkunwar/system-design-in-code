package com.example.parkinglot.service;

import com.example.parkinglot.model.Bill;
import com.example.parkinglot.repository.BillRepository;

public class BillService {
	private BillRepository billRepository;
	
	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	public Bill generateBill(Bill bill) {
		return billRepository.save(bill);
	}
}
