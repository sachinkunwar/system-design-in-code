package com.example.parkinglot.strategy;

import java.time.LocalDateTime;

public interface PricingStrategy {
	double calculatePrice(LocalDateTime parkingTime, LocalDateTime exitTime);
}
