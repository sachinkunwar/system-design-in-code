package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.ParkingSpot;

public class ParkingSpotRepository {
	private static long id;
	private HashMap<Long, ParkingSpot> repository;
	
	public ParkingSpotRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public ParkingSpot findById(long id) {
		return repository.get(id);
	}
	
	public ParkingSpot save(ParkingSpot parkingSpot) {
		ParkingSpot parkingSpot1 = findById(parkingSpot.getId());
		if(parkingSpot1 != null) {
			repository.put(parkingSpot.getId(), parkingSpot);
			return parkingSpot;
		}else {
			parkingSpot.setId(++id);
			repository.put(parkingSpot.getId(), parkingSpot);
			return parkingSpot;
		}
	}
	
	public ParkingSpot deleteById(long id) {
		return repository.remove(id);
	}
}
