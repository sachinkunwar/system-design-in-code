package com.example.urlshortener.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TokenManagerImpl implements TokenManager {
	
	private static long utilizedToken = 56800235584L;
	private static final long SIZE = 360000L;

	@Override
	synchronized public List<Long> nextAvailableTokenRange() {
		List<Long> range = new ArrayList<>();
		range.add(utilizedToken + 1);
		range.add(utilizedToken + SIZE);
		utilizedToken = utilizedToken + SIZE;
		return range;
	}

}
