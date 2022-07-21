package com.codegym.product.controller;

import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/product")
    public String getShowForm(@RequestParam(name = "name", defaultValue = "") String name,
                              @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Product> list = iProductService.findAll(name, PageRequest.of(page, 2, sort));
        model.addAttribute("listProduct", list);
        model.addAttribute("product", new Product());
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("product", iProductService.findById(id));
//        return "delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(Product product) {
//        iProductService.delete(product.getId());
//        return "redirect:/product";
//    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        iProductService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

//    @GetMapping("/search")
//    public String searchByName(String name, @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Page<Product> list = iProductService.searchByName(name, PageRequest.of(page, 1));
//        model.addAttribute("listProduct", list);
//        return "home";
//    }

}
