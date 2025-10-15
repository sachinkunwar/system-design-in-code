package com.example.parkinglot.service;

import java.time.LocalDateTime;

import com.example.parkinglot.model.Bill;
import com.example.parkinglot.model.Gate;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.constant.VehicleType;
import com.example.parkinglot.repository.BillRepository;
import com.example.parkinglot.strategy.FourWheelerPricingStrategy;
import com.example.parkinglot.strategy.TwoWheelerPricingStrategy;

public class BillService {
	private BillRepository billRepository;
	
	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	public Bill generateBill(Ticket ticket, Gate gate) {
		double amount = 0;
		LocalDateTime currentTime = LocalDateTime.now();
		if(ticket.getParkingSpot().getVehicleType().equals(VehicleType.TWO_WHEELER)) {
			amount = new TwoWheelerPricingStrategy().calculatePrice(ticket.getEntryTime(), currentTime);
		}else if(ticket.getParkingSpot().getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
			amount = new FourWheelerPricingStrategy().calculatePrice(ticket.getEntryTime(), currentTime);
		}
		Bill bill = new Bill();
		bill.setAmount(amount);
		bill.setExitTime(currentTime);
		bill.setTicket(ticket);
		bill.setGate(gate);
		return billRepository.save(bill);
	}
}
