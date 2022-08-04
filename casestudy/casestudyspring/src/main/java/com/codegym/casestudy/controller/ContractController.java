package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.service.contract.IContractService;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.employee.IEmployeeService;
import com.codegym.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("/contract")
    public String getShowFormContract(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Contract> list = iContractService.findAllContract(PageRequest.of(page, 5));
        model.addAttribute("listContract", list);
        model.addAttribute("listCustomer", iCustomerService.findAll());
        model.addAttribute("listEmployee", iEmployeeService.findAll());
        model.addAttribute("listFacility", iFacilityService.findAll());
        return "/contract/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("listCustomer", iCustomerService.findAll());
        model.addAttribute("listEmployee", iEmployeeService.findAll());
        model.addAttribute("listFacility", iFacilityService.findAll());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String save(Contract contract) {
        iContractService.create(contract);
        return "redirect:/contract/contract";
    }

}
