package com.example.parkinglot.repository;

import java.util.HashMap;

import com.example.parkinglot.model.Gate;

public class GateRepository {
	private static long id;
	private HashMap<Long, Gate> repository;
	
	public GateRepository() {
		id = 0;
		repository = new HashMap<>();
	}
	
	public Gate findById(long id) {
		return repository.get(id);
	}
	
	public Gate save(Gate gate) {
		Gate gate1 = findById(gate.getId());
		if(gate1 != null) {
			repository.put(gate.getId(), gate);
			return gate;
		}else {
			gate.setId(++id);
			repository.put(gate.getId(), gate);
			return gate;
		}
	}
	
	public Gate deleteById(long id) {
		return repository.remove(id);
	}
}
