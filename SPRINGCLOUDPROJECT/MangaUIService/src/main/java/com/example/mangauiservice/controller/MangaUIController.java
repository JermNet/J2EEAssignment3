package com.example.mangauiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class MangaUIController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String showSearchPage() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, Model model) {
        String url = "http://manga-service/search?title=" + title;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        model.addAttribute("mangaList", response.get("data"));
        return "index";
    }
}
