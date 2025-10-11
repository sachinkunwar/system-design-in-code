package com.example.parkinglot.service;

import java.time.LocalDateTime;

import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.repository.TicketRepository;

public class TicketService {
	private TicketRepository ticketRepository;
	
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public Ticket generateTicket(ParkingLot parkingLot, ParkingSpot parkingSpots) {
		Ticket ticket = new Ticket();
		ticket.setEntryTime(LocalDateTime.now());
		ticket.setGate(parkingLot.getEntryGate());
		ticket.setParkingSpot(parkingSpots);
		return ticketRepository.save(ticket);
	}
	
	public Ticket fetchTicket(String vehicleNumber) {
		return ticketRepository.findByVehcileNumber(vehicleNumber);
	}
}
