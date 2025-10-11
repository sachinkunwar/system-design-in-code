package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingAttendant;
import com.example.parkinglot.repository.ParkingAttendantRepository;

public class ParkingAttendantService {
	private ParkingAttendantRepository parkingAttendantRepository;
	
	public ParkingAttendantService(ParkingAttendantRepository parkingAttendantRepository) {
		this.parkingAttendantRepository = parkingAttendantRepository;
	}

	public ParkingAttendant create(ParkingAttendant parkingAttendant) {
		return parkingAttendantRepository.save(parkingAttendant);
	}
}
