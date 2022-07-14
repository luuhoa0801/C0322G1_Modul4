package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String getSandwich() {
        return "home";
    }

    @PostMapping("/update")
    public String save(@RequestParam(name = "check", required = false, defaultValue = "Chưa chọn gì cả") String[] condiment, Model model) {
        model.addAttribute("result", Arrays.toString(condiment));
        return "save";
    }

}
