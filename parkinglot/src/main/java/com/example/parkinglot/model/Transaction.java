package com.example.parkinglot.model;

import java.time.LocalDateTime;

import com.example.parkinglot.model.constant.TransactionMode;
import com.example.parkinglot.model.constant.TransactionStatus;

public class Transaction {
	private long id;
	private double amount;
	private TransactionStatus status;
	private LocalDateTime time;
	private TransactionMode mode;
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
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public TransactionMode getMode() {
		return mode;
	}
	public void setMode(TransactionMode mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", status=" + status + ", time=" + time + ", mode="
				+ mode + "]";
	}
}
