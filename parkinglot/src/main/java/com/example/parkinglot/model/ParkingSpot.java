package com.example.parkinglot.model;

import com.example.parkinglot.model.constant.ParkingSpotStatus;
import com.example.parkinglot.model.constant.VehicleType;

public class ParkingSpot {
	private long id;
	private VehicleType vehicleType;
	private ParkingSpotStatus parkingSpotStatus;
	private Vehicle vehicle;
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
	public ParkingSpotStatus getParkingSpotStatus() {
		return parkingSpotStatus;
	}
	public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
		this.parkingSpotStatus = parkingSpotStatus;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public String toString() {
		return "ParkingSpot [id=" + id + ", vehicleType=" + vehicleType + ", parkingSpotStatus=" + parkingSpotStatus
				+ ", vehicle=" + vehicle + "]";
	}
}
