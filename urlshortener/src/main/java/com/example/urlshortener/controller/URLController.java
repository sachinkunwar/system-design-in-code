package com.example.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.model.URL;
import com.example.urlshortener.service.URLService;

@RestController
public class URLController {
	
	@Autowired
	private URLService urlService;
	
	public URLController(URLService urlService) {
		this.urlService = urlService;
	}
	
	@PostMapping("/urlshortener")
	public URL generateShortUrl(URL url) {
		return urlService.generateShortUrl(url);
	}
	
	@GetMapping("/urlshortener/{token}")
	public URL fetchUrl(@PathVariable String token) {
		return urlService.fetchUrl(token);
	}
}
