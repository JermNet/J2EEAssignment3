package com.example.mangaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

// Since this is more of a sample than others, this is in this main class instead of separate since there's so much going on.
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MangaServiceApplication {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(MangaServiceApplication.class, args);
    }

    @GetMapping("/search")
    public Map<String, Object> searchManga(@RequestParam String title) {
        String url = "https://api.jikan.moe/v4/manga?q=" + title;
        return restTemplate.getForObject(url, Map.class);
    }
}
