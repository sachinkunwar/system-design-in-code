package com.example.parkinglot.service;

import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.repository.VehicleRepository;

public class VehicleService {
	private VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Vehicle fetchVehicle(String vehicleNumber) {
		return vehicleRepository.findByVehicleNumber(vehicleNumber);
	}
}
