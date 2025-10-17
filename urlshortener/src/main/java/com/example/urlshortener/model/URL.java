package com.example.urlshortener.model;

public class URL {
	private long id;
	private String originalUrl;
	private String token;
	private String shortUrl;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String longUrl) {
		this.originalUrl = longUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	@Override
	public String toString() {
		return "URL [id=" + id + ", longUrl=" + originalUrl + ", token=" + token + ", shortUrl=" + shortUrl +"]";
	}
}
