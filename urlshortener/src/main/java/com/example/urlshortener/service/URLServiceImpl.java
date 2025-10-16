package com.example.urlshortener.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.exception.URLNotFoundException;
import com.example.urlshortener.model.URL;
import com.example.urlshortener.repository.URLRepository;

@Service
public class URLServiceImpl implements URLService {
	Logger logger = LogManager.getLogger(URLServiceImpl.class);
	private static final char[] baseChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	
	@Autowired
	URLRepository urlRepository;
	
	@Autowired
	TokenManager tokenManager;
	
	private static final String baseShortUrl = "localhost:8080/urlshortener/";
	private long currId;
	private long lastId;
	
	public URLServiceImpl(URLRepository urlRepository, TokenManager tokenManager) {
		this.urlRepository = urlRepository;
		this.tokenManager = tokenManager;
		updateAvailableTokenRange();
	}

	@Override
	public URL generateShortUrl(URL url) {
		logger.info("Generating short url for the given URL: "+url.getLongUrl());
		if(currId > lastId) {
			updateAvailableTokenRange();
		}
		synchronized (this) {
			url.setId(currId++);
		}
		url.setToken(toBase62(url.getId()));
		url.setShortUrl(baseShortUrl+url.getToken());
		url = urlRepository.save(url);
		if(url == null) {
			throw new RuntimeException();
		}
		return url;
	}

	@Override
	public URL fetchUrl(String token) {
		logger.info("Fetching Long URL for Given Token: "+token);
		URL url = urlRepository.findByToken(token);
		if(url == null) throw new URLNotFoundException("URL not found for the given token: "+token);
		return url;
	}
	
	private String toBase62(long id) {
		logger.info("Generating Token for Given Id: "+id);
		StringBuilder sb = new StringBuilder();
		int base = 62;
		int rem = 0;
		while(id > 0) {
			rem = (int) (id % base);
			id = id / base;
			sb.append(baseChars[rem]);
		}
		return sb.toString();
	}
	
	private void updateAvailableTokenRange(){
		logger.info("Updating available token");
		synchronized(this) {
			if(currId == 0 || currId > lastId) {
				List<Long> resp = tokenManager.nextAvailableTokenRange();
				if(resp != null && resp.size() == 2) {
					this.currId = resp.get(0);
					this.lastId = resp.get(1);
				}
			}
		}
	}

}
