package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingFloor;
import com.example.parkinglot.repository.ParkingFloorRepository;

public class ParkingFloorService {
	private ParkingFloorRepository parkingFloorRepository;
	
	public ParkingFloorService(ParkingFloorRepository parkingFloorRepository) {
		this.parkingFloorRepository = parkingFloorRepository;
	}

	public ParkingFloor create(ParkingFloor parkingFloor) {
		return parkingFloorRepository.save(parkingFloor);
	}
}
