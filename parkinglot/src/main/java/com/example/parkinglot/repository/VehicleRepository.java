package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.Vehicle;

public class VehicleRepository {
	private static long id;
	private HashMap<String, Vehicle> repository;
	
	public VehicleRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public Vehicle findByVehicleNumber(String vehicleNumber) {
		return repository.get(vehicleNumber);
	}
	
	public Vehicle save(Vehicle vehicle) {
		Vehicle vehicle1 = findByVehicleNumber(vehicle.getVehicleNumber());
		if(vehicle1 != null) {
			return vehicle1;
		}else {
			vehicle.setId(++id);
			repository.put(vehicle.getVehicleNumber(), vehicle);
			return vehicle;
		}
	}
	
	public Vehicle deleteByVehicleNumber(String vehicleNumber) {
		return repository.remove(vehicleNumber);
	}
}
