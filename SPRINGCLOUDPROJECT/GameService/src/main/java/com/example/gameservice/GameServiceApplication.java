package com.example.gameservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// Since this is more of a sample than others, this is in this main class instead of separate since there's so much going on.
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GameServiceApplication {

    // Get value from application.yml
    @Value("${rawg.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }

    // Search using the query and get the rest template with it.
    @GetMapping("/search")
    public String searchGames(@RequestParam String query) {
        String url = "https://api.rawg.io/api/games?search=" + query + "&key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

}
