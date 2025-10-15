package com.example.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.exception.URLNotFoundException;
import com.example.urlshortener.model.URL;
import com.example.urlshortener.repository.URLRepository;

@Service
public class URLServiceImpl implements URLService {
	
	@Autowired
	URLRepository urlRepository;
	
	public URLServiceImpl(URLRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	@Override
	public URL generateShortUrl(URL url) {
		// TODO write logic to generate short url
		url = urlRepository.save(url);
		if(url == null) throw new RuntimeException();
		return url;
	}

	@Override
	public URL fetchUrl(String token) {
		URL url = urlRepository.findByToken(token);
		if(url == null) throw new URLNotFoundException("URL not found for the given token: "+token);
		return url;
	}

}
