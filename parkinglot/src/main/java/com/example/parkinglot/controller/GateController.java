package com.example.parkinglot.controller;

import com.example.parkinglot.model.Gate;
import com.example.parkinglot.service.GateService;

public class GateController {
	private GateService gateService;
	
	public GateController(GateService gateService) {
		this.gateService = gateService;
	}
	
	public Gate create(Gate gate) {
		return gateService.create(gate);
	}

	public Gate fetchGate(long id) {
		return gateService.fetchGate(id);
	}
}
