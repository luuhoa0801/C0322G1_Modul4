package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/product")
    public String getShowForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", iProductService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(Product product,RedirectAttributes redirectAttributes) {
        product.setId(iProductService.findAll().get(iProductService.findAll().size() - 1).getId() + 1);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công " + product.getName());
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("msg", "xóa thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String searchByName(Product product, Model model) {
        model.addAttribute("listProduct", iProductService.searchByName(product.getName()));
        return "home";
    }

}
