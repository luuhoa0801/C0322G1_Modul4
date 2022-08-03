package com.codegym.casestudy.controller;

import com.codegym.casestudy.controller.dto.EmployeeDto;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationService iEducationService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IUserService iUserService;

//    @ModelAttribute("listDivision")
//    public List<Division> findAllDivision() {
//        return this.iDivisionService.findAll();
//    }

    @GetMapping("/employee")
    public String showForm(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                           @RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("listEmployee", iEmployeeService.findAllEmployee(name, pageable));
        model.addAttribute("name", name);
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("listDivision", iDivisionService.findAll());
        model.addAttribute("listEducation", iEducationService.findAll());
        model.addAttribute("listPosition", iPositionService.findAll());
        model.addAttribute("listUser", iUserService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("employee") @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listDivision", iDivisionService.findAll());
            model.addAttribute("listEducation", iEducationService.findAll());
            model.addAttribute("listPosition", iPositionService.findAll());
            model.addAttribute("listUser", iUserService.findAll());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.create(employee);
            return "redirect:/employee/employee";
        }

    }


    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable int id) {
        iEmployeeService.delete(id);
        return "redirect:/employee/employee";
    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employeeList", iEmployeeService.findById(id));
        model.addAttribute("listDivision", iDivisionService.findAll());
        model.addAttribute("listEducation", iEducationService.findAll());
        model.addAttribute("listPosition", iPositionService.findAll());
        model.addAttribute("listUser", iUserService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute(name = "employeeList") EmployeeDto employeeDto,BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("listDivision", iDivisionService.findAll());
            model.addAttribute("listEducation", iEducationService.findAll());
            model.addAttribute("listPosition", iPositionService.findAll());
            model.addAttribute("listUser", iUserService.findAll());
            return "employee/edit";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.update(employee);
            return "redirect:/employee/employee";
        }

    }


}
