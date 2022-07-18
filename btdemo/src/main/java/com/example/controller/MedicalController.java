package com.example.controller;

import com.example.service.IMedicalService;
import com.example.model.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/list")
    public String fillAll(Model model) {
        model.addAttribute("listMedical", iMedicalService.fillAll());
        return "list";
    }

    @GetMapping("/medical")
    public String showForm(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("listYear", iMedicalService.year());
//        model.addAttribute("listTravel",iMedicalService.travel());
        model.addAttribute("listStartDay",iMedicalService.startDay());
        model.addAttribute("listEndDay",iMedicalService.endDay());
        return "create";
    }

    @PostMapping("/addMedical")
    public String addMedical(@ModelAttribute("medical") Medical medical, Model model) {
        iMedicalService.save(medical);
        model.addAttribute("medical", medical);
        return "show";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("medical", iMedicalService.findById(id));
        model.addAttribute("listYear", iMedicalService.year());
//        model.addAttribute("listTravel",iMedicalService.travel());
        model.addAttribute("listStartDay",iMedicalService.startDay());
        model.addAttribute("listEndDay",iMedicalService.endDay());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Medical medical) {
        iMedicalService.update(medical.getId(), medical);
        return "redirect:/list";
    }
}
