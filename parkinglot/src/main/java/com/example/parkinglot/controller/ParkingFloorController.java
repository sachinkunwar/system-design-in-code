package com.example.parkinglot.controller;

import com.example.parkinglot.model.ParkingFloor;
import com.example.parkinglot.service.ParkingFloorService;

public class ParkingFloorController {
	private ParkingFloorService parkingFloorService;
	
	public ParkingFloorController(ParkingFloorService parkingFloorService) {
		this.parkingFloorService = parkingFloorService;
	}

	public ParkingFloor create(ParkingFloor parkingFloor) {
		return parkingFloorService.create(parkingFloor);
	}
}
