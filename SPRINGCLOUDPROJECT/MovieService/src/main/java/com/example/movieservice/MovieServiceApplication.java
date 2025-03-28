package com.example.movieservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.Authentication;

import java.util.Map;

// Since this is more of a sample than others, this is in this main class instead of separate since there's so much going on.
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MovieServiceApplication {

    // Get value from application.yml
    @Value("${omdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication.class, args);
    }

    // Search using the query and get the rest template with it.
    @GetMapping("/search")
    public Map<String, Object> searchMovies(@RequestParam String title) {
        String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&s=" + title;
        return restTemplate.getForObject(url, Map.class);
    }
}
