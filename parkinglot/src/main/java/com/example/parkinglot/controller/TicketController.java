package com.example.parkinglot.controller;

import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.TicketService;

public class TicketController {
	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public Ticket fetchTicket(Vehicle vehicle) {
		return ticketService.fetchTicket(vehicle.getVehicleNumber());
	}
}
