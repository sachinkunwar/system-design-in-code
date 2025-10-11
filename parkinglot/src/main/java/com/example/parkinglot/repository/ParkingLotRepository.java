package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.ParkingLot;

public class ParkingLotRepository {
	private static long id;
	private HashMap<Long, ParkingLot> repository;
	
	public ParkingLotRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public ParkingLot findById(long id) {
		return repository.get(id);
	}
	
	public ParkingLot save(ParkingLot parkingLot) {
		ParkingLot parkingLot1 = findById(parkingLot.getId());
		if(parkingLot1 != null) {
			repository.put(parkingLot.getId(), parkingLot);
			return parkingLot;
		}else {
			parkingLot.setId(++id);
			repository.put(parkingLot.getId(), parkingLot);
			return parkingLot;
		}
	}
	
	public ParkingLot deleteById(long id) {
		return repository.remove(id);
	}
}
