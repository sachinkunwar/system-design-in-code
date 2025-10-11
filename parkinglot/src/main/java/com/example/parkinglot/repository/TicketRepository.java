package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.Ticket;

public class TicketRepository {
	private static long id;
	private HashMap<String, Ticket> repository;
	
	public TicketRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public Ticket findByVehcileNumber(String vehicleNumber) {
		return repository.get(vehicleNumber);
	}
	
	public Ticket save(Ticket ticket) {
		String vehicleNumber = ticket.getParkingSpot().getVehicle().getVehicleNumber();
		Ticket ticket1 = findByVehcileNumber(vehicleNumber);
		if(ticket1 != null) {
			repository.put(vehicleNumber, ticket);
			return ticket;
		}else {
			ticket.setId(++id);
			repository.put(vehicleNumber, ticket);
			return ticket;
		}
	}
	
	public Ticket deleteById(String vehicleNumber) {
		return repository.remove(vehicleNumber);
	}
}
