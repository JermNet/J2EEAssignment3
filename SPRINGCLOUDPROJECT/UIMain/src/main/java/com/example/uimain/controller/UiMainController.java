package com.example.uimain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiMainController {
    // Get the main page
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
