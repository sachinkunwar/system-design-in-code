package com.example.parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {
	private long id;
	private ParkingSpot parkingSpot;
	private LocalDateTime entryTime;
	private Gate gate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public Gate getGate() {
		return gate;
	}
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", parkingSpot=" + parkingSpot + ", entryTime=" + entryTime + ", gate=" + gate
				+ "]";
	}
}
