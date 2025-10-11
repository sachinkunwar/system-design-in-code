package com.example.parkinglot.model;

import com.example.parkinglot.model.constant.VehicleType;

public class Vehicle {
	private long id;
	private VehicleType vehicleType;
	private String vehicleNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + "]";
	}
}