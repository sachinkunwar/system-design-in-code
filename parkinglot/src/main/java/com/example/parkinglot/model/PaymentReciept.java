package com.example.parkinglot.model;

import java.time.LocalDateTime;
import java.util.List;

public class PaymentReciept {
	private long id;
	private List<Transaction> transactions;
	private double amount;
	private LocalDateTime time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "PaymentReciept [id=" + id + ", transactions=" + transactions + ", amount=" + amount + ", time=" + time
				+ "]";
	}
}
