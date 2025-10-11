package com.example.parkinglot.controller;

import com.example.parkinglot.model.ParkingAttendant;
import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.service.ParkingAttendantService;

public class ParkingAttendantController {
	private ParkingAttendantService parkingAttendantService;
	
	public ParkingAttendantController(ParkingAttendantService parkingAttendantService) {
		this.parkingAttendantService = parkingAttendantService;
	}

	public ParkingAttendant create(ParkingAttendant parkingAttendant) {
		return parkingAttendantService.create(parkingAttendant);
	}
	
}
