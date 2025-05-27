package com.yoanpetrov.backendjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService
{
    private final ShortUrlGenerationService shortUrlGenerationService;
    private final LinkDao                   linkDao;
    private final int                       shortUrlSaveRetries;

    public UrlShortenerService(ShortUrlGenerationService shortUrlGenerationService,
                               LinkDao linkDao,
                               @Value("${app.short-links.save-retries}") int shortUrlSaveRetries)
    {
        this.shortUrlGenerationService = shortUrlGenerationService;
        this.linkDao = linkDao;
        this.shortUrlSaveRetries = shortUrlSaveRetries;
    }

    public String createShortLink(String originalUrl)
    {
        for (int i = 0; i < shortUrlSaveRetries; i++) {
            String shortLink = shortUrlGenerationService.generateRandomShortUrl();
            if (linkDao.saveLink(shortLink, originalUrl)) {
                return shortLink;
            }
        }
        return null;
    }

    public String getOriginalUrl(String shortLink)
    {
        return linkDao.findOriginalUrlByShortUrl(shortLink).orElse(null);
    }
}
