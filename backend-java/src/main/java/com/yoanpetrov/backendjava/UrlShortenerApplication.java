package com.yoanpetrov.backendjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UrlShortenerApplication
{

    public static void main(String[] args)
    {
        var context = SpringApplication.run(UrlShortenerApplication.class, args);
        LinkDao dao = context.getBean("linkDao", LinkDao.class);
        System.out.println(dao.saveLink("asd", "original url"));
        System.out.println(dao.saveLink("asd", "original url 2"));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}
