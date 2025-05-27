package com.yoanpetrov.backendjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{

    @PostMapping("/api/shorten")
    public String createLink()
    {
        return "CREATE";
    }

    @GetMapping("/{shortLink}")
    public String getLong(@PathVariable String shortLink)
    {
        return "LONG LINK for short link: " + shortLink;
    }
}
