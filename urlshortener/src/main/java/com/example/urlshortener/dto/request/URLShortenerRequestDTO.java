package com.example.urlshortener.dto.request;

public class URLShortenerRequestDTO {

	private String originalUrl;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	@Override
	public String toString() {
		return "URLShortenerRequestDTO [originalUrl=" + originalUrl + "]";
	}
	
}
