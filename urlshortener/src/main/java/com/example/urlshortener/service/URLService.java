package com.example.urlshortener.service;

import com.example.urlshortener.dto.request.URLShortenerRequestDTO;
import com.example.urlshortener.model.URL;

public interface URLService {
	URL generateShortUrl(URLShortenerRequestDTO dto);
	URL fetchUrl(String tiken);
}
