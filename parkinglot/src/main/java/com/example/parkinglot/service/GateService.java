package com.example.parkinglot.service;

import com.example.parkinglot.model.Gate;
import com.example.parkinglot.repository.GateRepository;

public class GateService {
	private GateRepository gateRepository;
	
	public GateService(GateRepository gateRepository) {
		this.gateRepository = gateRepository;
	}

	public Gate create(Gate gate) {
		return gateRepository.save(gate);
	}

	public Gate fetchGate(long id) {
		return gateRepository.findById(id);
	}
}
