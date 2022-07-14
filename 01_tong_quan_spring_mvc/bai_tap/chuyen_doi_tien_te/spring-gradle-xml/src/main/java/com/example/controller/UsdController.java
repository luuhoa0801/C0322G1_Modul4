package com.example.controller;


import com.example.service.IUsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("bt")
public class UsdController {
    @Autowired
    private IUsdService iUsdService;

    @GetMapping("/money")
    public String getUsd() {
        return "home";
    }

    @PostMapping("/money")
    public String PostUsd(@RequestParam(name = "usd", defaultValue = "1") String usd, Model model) {
        model.addAttribute("result", iUsdService.usdNumber(usd));
        model.addAttribute("usd", usd);
        return "home";
    }

}
