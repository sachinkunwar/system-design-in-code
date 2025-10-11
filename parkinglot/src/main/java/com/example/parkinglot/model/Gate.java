package com.example.parkinglot.model;

import com.example.parkinglot.model.constant.GateType;

public class Gate {
	private long id;
	private GateType gatetype;
	private ParkingAttendant parkingAttendant;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public GateType getGatetype() {
		return gatetype;
	}
	public void setGatetype(GateType gatetype) {
		this.gatetype = gatetype;
	}
	public ParkingAttendant getParkingAttendant() {
		return parkingAttendant;
	}
	public void setParkingAttendant(ParkingAttendant parkingAttendant) {
		this.parkingAttendant = parkingAttendant;
	}
	@Override
	public String toString() {
		return "Gate [id=" + id + ", gatetype=" + gatetype + ", parkingAttendant=" + parkingAttendant + "]";
	}
}
