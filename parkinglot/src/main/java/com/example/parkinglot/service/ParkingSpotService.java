package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.constant.ParkingSpotStatus;
import com.example.parkinglot.repository.ParkingSpotRepository;

public class ParkingSpotService {
	private ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	public ParkingSpot create(ParkingSpot parkingSpot) {
		return parkingSpotRepository.save(parkingSpot);
	}

	public boolean releaseParkingSpot(ParkingSpot parkingSpot) {
		parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FREE);
		parkingSpot.setVehicle(null);
		return true;
	}
}
