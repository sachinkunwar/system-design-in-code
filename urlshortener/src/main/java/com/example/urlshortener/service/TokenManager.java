package com.example.urlshortener.service;

import java.util.List;

public interface TokenManager {
	List<Long> nextAvailableTokenRange();
}
