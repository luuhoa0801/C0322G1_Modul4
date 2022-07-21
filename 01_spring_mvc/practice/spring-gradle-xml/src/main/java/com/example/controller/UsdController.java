package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsdController {
    @GetMapping("/usd")
    public String greeting() {
        return "home";
    }

    @PostMapping("/tiente")
    public String greeting1(@RequestParam(name = "usd") int number, Model model) {
        int result = number * 23000;
        model.addAttribute("result", result);
        return "home";
    }
}
