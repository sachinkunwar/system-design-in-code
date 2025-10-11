package com.example.parkinglot.model;

public class ParkingAttendant {
	private long id;
	private String name;
	private String mobileNumber;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "ParkingAttendant [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}
}
