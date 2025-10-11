package com.example.parkinglot.controller;

import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.service.ParkingSpotService;

public class ParkingSpotController {
	private ParkingSpotService parkingSpotService;
	
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}
	
	public ParkingSpot create(ParkingSpot parkingSpot) {
		return parkingSpotService.create(parkingSpot);
	}
	
	public boolean releaseParkingSpot(ParkingSpot parkingSpot) {
		return parkingSpotService.releaseParkingSpot(parkingSpot);
	}
}
