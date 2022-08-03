package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String home() {
        return "/index";
    }

    @GetMapping("/customer")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> list = iCustomerService.getAll(PageRequest.of(page, 5));
        model.addAttribute("listCustomer", list);
        model.addAttribute("listCustomerType", iCustomerTypeService.findAllType());
        return "/customer/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("CustomerList", iCustomerService.findById(id));
        List<CustomerType> customerTypeList = iCustomerService.customerTypeList();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(name = "CustomerList") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable int id) {
        iCustomerService.delete(id);
        return "redirect:/customer";
    }

}
