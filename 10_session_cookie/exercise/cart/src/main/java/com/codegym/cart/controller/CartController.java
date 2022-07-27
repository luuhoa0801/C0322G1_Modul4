package com.codegym.cart.controller;

import com.codegym.cart.model.Cart;
import com.codegym.cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cartShow")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cartShow")
    public List<Cart> createCartList() {
        return new ArrayList<>();
    }

    @GetMapping("/cart")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Cart> list = iCartService.getAll(PageRequest.of(page, 3));
        model.addAttribute("listCart", list);
        return "list";
    }

    @GetMapping("/views/{idCart}")
    public String viewsFrom(@PathVariable("idCart") Integer idCart, Model model) {
        model.addAttribute("listViews", iCartService.findById(idCart));
        return "views";
    }

    @GetMapping("cart/{idCart}")
    public String addToCart(@PathVariable("idCart") Integer idCart, @ModelAttribute("cartShow") List<Cart> cartList,
                            RedirectAttributes redirectAttributes) {
        Cart cart = iCartService.findById(idCart);
        cartList.add(cart);
        redirectAttributes.addFlashAttribute("msg", "Đã thêm vào giỏ hàng");
        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String order(@ModelAttribute("cartShow") List<Cart> cartList, Model model) {
        model.addAttribute("cartList", cartList);
        int total = 0;
        for (Cart item : cartList) {
            total += item.getPrice();
        }
        model.addAttribute("item", total);
        return "order";
    }

    @GetMapping("/cart/delete")
    public String delete(@ModelAttribute("cartShow") List<Cart> cartList) {
        cartList.clear();
        return "redirect:/cart";
    }


}
