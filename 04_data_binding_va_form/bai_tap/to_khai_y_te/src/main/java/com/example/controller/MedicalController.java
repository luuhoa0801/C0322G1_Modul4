package com.example.controller;

import com.example.model.Medical;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/medical")
    public String showForm(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("listYear", iMedicalService.yearSer());
        model.addAttribute("listLanguages", iMedicalService.languagesSer());
        model.addAttribute("listGender", iMedicalService.genderSer());
        return "home";
    }

    @PostMapping("/addMedical")
    public String addMedical(@ModelAttribute("medical") Medical medical, Model model) {
        model.addAttribute("medical", medical);
        return "info";
    }
}
