package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.facility.Facility;
import com.codegym.casestudy.service.facility.IFacilityService;
import com.codegym.casestudy.service.facility.IFacilityTypeService;
import com.codegym.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("service")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/facility")
    public String showForm(@PageableDefault(value = 5,sort = "id",direction = Sort.Direction.ASC) Pageable pageable,
                           @RequestParam(value = "name",defaultValue = "") String name, Model model){
        model.addAttribute("listFacility",iFacilityService.getAll(name,pageable));
        model.addAttribute("listFacilityType",iFacilityTypeService.findAllFacilityType());
        model.addAttribute("listRentType",iRentTypeService.findAllRentType());
        model.addAttribute("name",name);
        return "facility/list";
    }

    @GetMapping("/create/{name}")
    public String showFormFacility(@PathVariable(name = "name") String name, Model model) {
        model.addAttribute("facility",new Facility());
        model.addAttribute("listFacilityType", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("listRentType", iRentTypeService.findAllRentType());
        model.addAttribute("name", name);
        return "facility/create";
    }

    @PostMapping("/create")
    public String createFacility(@ModelAttribute(name = "facility") Facility facility) {
        iFacilityService.create(facility);
        return "redirect:/service/facility";
    }

    @GetMapping("/{id}/edit")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("facility", iFacilityService.findById(id).get());
        model.addAttribute("listFacilityType", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentType());
        return "facility/update";
    }

    @PostMapping("/update")
    public String update ( @ModelAttribute(name = "facility") Facility facility){
        System.out.println(facility);
        iFacilityService.update(facility);
        return "redirect:/service/facility";
    }

    @GetMapping("/facility/delete/{id}")
    public String delete(@PathVariable int id) {
        iFacilityService.delete(id);
        return "redirect:/service/facility";
    }
}
