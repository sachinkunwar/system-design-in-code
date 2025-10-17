package com.example.urlshortener.dto.response;

public class URLShortenerResponseDTO {
	private String status;
	private String originalUrl;
	private String shortUrl;
	private String token;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "URLShortenerResponseDTO [status=" + status + ", originalUrl=" + originalUrl + ", shortUrl=" + shortUrl
				+ ", token=" + token + "]";
	}
}
