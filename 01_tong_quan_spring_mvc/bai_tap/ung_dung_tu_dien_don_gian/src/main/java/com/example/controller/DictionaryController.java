package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/dictionary")
    public String getDictionary() {
        return "home";
    }

    @PostMapping("/dictionary")
    public String postDictionary(@RequestParam(name = "world") String world, Model model) {
        model.addAttribute("result", iDictionaryService.late(world));
        model.addAttribute("english",world);
        return "home";
    }
}
