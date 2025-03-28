package com.example.movieuiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class MovieUIController {

    @Autowired
    private RestTemplate restTemplate;

    // Get the main page
    @GetMapping("/")
    public String showSearchPage() {
        return "index";
    }

    // Get the main page with a search
    @GetMapping("/search")
    public String searchMovies(@RequestParam String title, Model model) {
        String url = "http://movie-service/search?title=" + title;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        model.addAttribute("movies", response.get("Search"));
        return "index";
    }
}
