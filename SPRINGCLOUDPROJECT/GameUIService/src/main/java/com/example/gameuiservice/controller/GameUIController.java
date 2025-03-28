package com.example.gameuiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class GameUIController {
    @Autowired
    private RestTemplate restTemplate;

    // Get the main page
    @GetMapping("/")
    public String showSearchPage() {
        return "index";
    }

    // Get the main page with a search
    @GetMapping("/search")
    public String searchGames(@RequestParam String query, Model model) {
        String url = "http://game-service/search?query=" + query;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        model.addAttribute("games", response.get("results"));
        return "index";
    }

}
