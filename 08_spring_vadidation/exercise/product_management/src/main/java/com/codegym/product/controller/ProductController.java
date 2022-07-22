package com.codegym.product.controller;


import com.codegym.product.model.Product;
import com.codegym.product.dto.ProductDto;
import com.codegym.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/product")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.getAll(PageRequest.of(page, 2));
        model.addAttribute("listProduct", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("product") @Validated ProductDto productDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto,product);
            iProductService.create(product);
            redirectAttributes.addFlashAttribute("msg", "thêm mới thành công" +product.getName());
            return "redirect:/product";
        }

    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findByIdSearch(id));
        return "edit";
    }

    @PostMapping("/update")
    public String PostUpdate(@Valid @ModelAttribute(name = "product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }
        iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findByIdSearch(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product) {
        iProductService.delete(product.getId());
        return "redirect:/product";
    }

}
