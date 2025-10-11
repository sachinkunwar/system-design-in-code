package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.ParkingAttendant;

public class ParkingAttendantRepository {
	private static long id;
	private HashMap<Long, ParkingAttendant> repository;
	
	public ParkingAttendantRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public ParkingAttendant findById(long id) {
		return repository.get(id);
	}
	
	public ParkingAttendant save(ParkingAttendant parkingAttendant) {
		ParkingAttendant parkingAttendant1 = findById(parkingAttendant.getId());
		if(parkingAttendant1 != null) {
			repository.put(parkingAttendant.getId(), parkingAttendant);
			return parkingAttendant;
		}else {
			parkingAttendant.setId(++id);
			repository.put(parkingAttendant.getId(), parkingAttendant);
			return parkingAttendant;
		}
	}
	
	public ParkingAttendant deleteById(long id) {
		return repository.remove(id);
	}
}
