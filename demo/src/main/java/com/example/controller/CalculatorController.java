package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/calculator")
    public String showForm(){
        return "home";
    }
    @PostMapping("/calculator")
    public String postCalculator(@RequestParam(name = "number1") String number1,
                                 @RequestParam(name = "number2") String number2,
                                 @RequestParam(name = "check") char check,
                                 Model model) {
        model.addAttribute("result", iCalculatorService.calculator(number1, number2, check));
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "home";
    }

}
