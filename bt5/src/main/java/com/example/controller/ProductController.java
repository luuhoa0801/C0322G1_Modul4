package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("/product")
    public String getShowForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", iProductService.fillAll());
        return "home";
    }
    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id) {
        iProductService.delete(id);
        return "redirect:/product";
    }
}
