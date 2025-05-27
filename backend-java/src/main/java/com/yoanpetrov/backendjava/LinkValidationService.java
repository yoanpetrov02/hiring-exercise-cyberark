package com.yoanpetrov.backendjava;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LinkValidationService
{
    public boolean validateUrl(String url)
    {
        try {
            new URI(url).toURL();
            return true;
        } catch (MalformedURLException | URISyntaxException | IllegalArgumentException e) {
            return false;
        }
    }
}
