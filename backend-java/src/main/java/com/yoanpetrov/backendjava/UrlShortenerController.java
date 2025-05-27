package com.yoanpetrov.backendjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController
{
    private final UrlShortenerService urlShortenerService;
    private final String              baseUrl;

    public UrlShortenerController(UrlShortenerService urlShortenerService,
                                  @Value("${app.public.base-url}") String baseUrl)
    {
        this.urlShortenerService = urlShortenerService;
        this.baseUrl = baseUrl;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody ShorteningRequest shorteningRequest)
    {
        String shortCode = urlShortenerService.createShortLink(shorteningRequest.url());
        if (shortCode == null) {
            return new ResponseEntity<>("Could not generate short URL", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ShorteningResponse(shortCode,
                                                           "%s/%s".formatted(baseUrl, shortCode),
                                                           shorteningRequest.url()),
                                    HttpStatus.CREATED);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl)
    {
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        if (originalUrl == null) {
            return new ResponseEntity<>("URL not found", HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, originalUrl);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
