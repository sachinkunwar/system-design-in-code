package com.example.parkinglot.model;

import java.util.List;

public class ParkingLot {
	private long id;
	private String name;
	private String address;
	private List<ParkingFloor> parkingFloors;
	private Gate entryGate;
	private Gate exitGate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}
	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}
	public Gate getEntryGate() {
		return entryGate;
	}
	public void setEntryGate(Gate entryGate) {
		this.entryGate = entryGate;
	}
	public Gate getExitGate() {
		return exitGate;
	}
	public void setExitGate(Gate exitGate) {
		this.exitGate = exitGate;
	}
	@Override
	public String toString() {
		return "ParkingLot [id=" + id + ", name=" + name + ", address=" + address + ", parkingFloors=" + parkingFloors
				+ ", entryGate=" + entryGate + ", exitGate=" + exitGate + "]";
	}
}
