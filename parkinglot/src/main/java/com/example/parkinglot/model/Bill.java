package com.example.parkinglot.model;

import java.time.LocalDateTime;

public class Bill {
	private long id;
	private double amount;
	private Ticket ticket;
	private LocalDateTime exitTime;
	private Gate gate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public Gate getGate() {
		return gate;
	}
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", amount=" + amount + ", ticket=" + ticket + ", exitTime=" + exitTime + ", gate="
				+ gate + "]";
	}
}
