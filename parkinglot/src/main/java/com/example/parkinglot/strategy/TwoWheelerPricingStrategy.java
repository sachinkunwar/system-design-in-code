package com.example.parkinglot.strategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class TwoWheelerPricingStrategy implements PricingStrategy {

	@Override
	public double calculatePrice(LocalDateTime parkingTime, LocalDateTime exitTime) {
		Duration duration = Duration.between(parkingTime, exitTime);
		long millis = duration.toSeconds();
		return millis*0.5;
	}

}
