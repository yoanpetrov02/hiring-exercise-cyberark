package com.yoanpetrov.backendjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShortUrlGenerationService
{
    private static final String BASE58_ALPHABET =
            "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    private static final int BASE = BASE58_ALPHABET.length();

    private final int    shortLinkLength;
    private final Random random;

    public ShortUrlGenerationService(@Value("${app.short-links.length}") int shortLinkLength)
    {
        this.shortLinkLength = shortLinkLength;
        this.random = new Random();
    }

    public String generateRandomShortUrl()
    {
        StringBuilder s = new StringBuilder(shortLinkLength);
        for (int i = 0; i < shortLinkLength; i++) {
            int index = random.nextInt(BASE);
            s.append(BASE58_ALPHABET.charAt(index));
        }
        return s.toString();
    }
}
