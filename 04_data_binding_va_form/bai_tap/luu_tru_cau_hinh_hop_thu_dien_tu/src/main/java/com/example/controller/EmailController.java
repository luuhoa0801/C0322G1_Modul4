package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/list")
    public String fillAll(Model model) {
        model.addAttribute("listEmail", iEmailService.fillAll());
        return "list";
    }

    @GetMapping("/email")
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        model.addAttribute("listLanguages", iEmailService.listLanguages());
        model.addAttribute("listSize", iEmailService.listSize());
        return "create";
    }

    @PostMapping("/addEmail")
    public String addEmail(@ModelAttribute("email") Email email, Model model) {
        iEmailService.save(email);
        model.addAttribute("email", email);
        return "show";
    }
}
