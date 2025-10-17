package com.example.urlshortener.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.constant.Status;
import com.example.urlshortener.dto.request.URLShortenerRequestDTO;
import com.example.urlshortener.dto.response.URLShortenerResponseDTO;
import com.example.urlshortener.exception.URLNotFoundException;
import com.example.urlshortener.model.URL;
import com.example.urlshortener.service.URLService;

@RestController
@RequestMapping("/api/v1")
public class URLController {
	
	@Autowired
	private URLService urlService;
	
	public URLController(URLService urlService) {
		this.urlService = urlService;
	}
	
	@PostMapping("/shorten")
	public ResponseEntity<URLShortenerResponseDTO> generateShortUrl(@RequestBody URLShortenerRequestDTO dto) {
		URL urlResponse = urlService.generateShortUrl(dto);
		if(urlResponse != null) {
			URLShortenerResponseDTO response = new URLShortenerResponseDTO();
			response.setOriginalUrl(urlResponse.getOriginalUrl());
			response.setToken(urlResponse.getToken());
			response.setShortUrl(urlResponse.getShortUrl());
			response.setStatus(Status.Success.name());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		throw new RuntimeException("Short URL could not be generated for URL: "+dto.getOriginalUrl());
	}
	
	@GetMapping("/token/{token}")
	public ResponseEntity<Void> fetchUrl(@PathVariable String token) throws URISyntaxException{
		URL url = urlService.fetchUrl(token);
		if(url != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(new URI(url.getOriginalUrl()));
			return new ResponseEntity<>(headers, HttpStatus.FOUND);
		}
		throw new URLNotFoundException("URL Not Found For the Given Token: "+token);
	}
}
