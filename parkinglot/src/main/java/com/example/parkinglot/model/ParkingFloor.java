package com.example.parkinglot.model;

import java.util.List;

public class ParkingFloor {
	private long id;
	private List<ParkingSpot> parkingSpots;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}
	public void setParkingSpots(List<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}
	@Override
	public String toString() {
		return "ParkingFloor [id=" + id + ", parkingSpots=" + parkingSpots + "]";
	}	
}
