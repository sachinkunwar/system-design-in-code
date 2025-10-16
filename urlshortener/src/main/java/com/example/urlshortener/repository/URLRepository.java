package com.example.urlshortener.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.example.urlshortener.model.URL;

@Component
public class URLRepository {
	private HashMap<String, URL> map;
	
	public URLRepository() {
		map = new HashMap<>();
	}
	
	public URL save(URL url) {
		map.put(url.getToken(), url);
		return url;
	}
	
	public URL findByToken(String token) {
		return map.get(token);
	}
	
	public URL deleteByShortUrl(String token) {
		return map.remove(token);
	}
}
