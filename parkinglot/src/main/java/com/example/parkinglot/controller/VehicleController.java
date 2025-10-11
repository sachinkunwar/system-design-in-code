package com.example.parkinglot.controller;

import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.VehicleService;

public class VehicleController {
	private VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	public Vehicle create(Vehicle vehicle) {
		return vehicleService.create(vehicle);
	}
	
	public Vehicle fetchVehicle(String vehicleNumber) {
		return vehicleService.fetchVehicle(vehicleNumber);
	}
}
