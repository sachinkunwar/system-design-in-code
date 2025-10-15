package com.example.urlshortener.service;

import com.example.urlshortener.model.URL;

public interface URLService {
	URL generateShortUrl(URL url);
	URL fetchUrl(String tiken);
}
