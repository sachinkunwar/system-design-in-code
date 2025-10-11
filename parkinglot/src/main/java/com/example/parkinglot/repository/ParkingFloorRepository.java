package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.ParkingFloor;

public class ParkingFloorRepository {
	private static long id;
	private HashMap<Long, ParkingFloor> repository;
	
	public ParkingFloorRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public ParkingFloor findById(long id) {
		return repository.get(id);
	}
	
	public ParkingFloor save(ParkingFloor parkingFloor) {
		ParkingFloor parkingFloor1 = findById(parkingFloor.getId());
		if(parkingFloor1 != null) {
			repository.put(parkingFloor.getId(), parkingFloor);
			return parkingFloor;
		}else {
			parkingFloor.setId(++id);
			repository.put(parkingFloor.getId(), parkingFloor);
			return parkingFloor;
		}
	}
	
	public ParkingFloor deleteById(long id) {
		return repository.remove(id);
	}
}
