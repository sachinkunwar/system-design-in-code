package com.example.urlshortener.dto.response;

public class URLLookupResponseDTO {
	private String status;
	private String originalUrl;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "URLLookupResponseDTO [status=" + status + ", originalUrl=" + originalUrl + ", token=" + token + "]";
	}
}
