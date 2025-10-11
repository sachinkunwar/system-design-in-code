package com.example.parkinglot.controller;

import com.example.parkinglot.model.Bill;
import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.ParkingLotService;

public class ParkingLotController {
	private ParkingLotService parkingLotService;
	
	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}
	
	public ParkingLot create(ParkingLot parkingLot) {
		return parkingLotService.create(parkingLot);
	}
	
	public Ticket park(ParkingLot parkingLot, Vehicle vehicle) {
		return parkingLotService.park(parkingLot, vehicle);
	}
	
	public void showParkingSpots(ParkingLot parkingLot) {
		parkingLotService.showParkingSpots(parkingLot);
	}
}
