package com.example.urlshortener.model;

public class URL {
	private long id;
	private String longUrl;
	private String token;
	private String shortUrl;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
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
		return "URL [id=" + id + ", longUrl=" + longUrl + ", token=" + token + ", shortUrl=" + shortUrl +"]";
	}
}
