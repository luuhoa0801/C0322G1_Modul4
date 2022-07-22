package com.codegym.form_user.controller;

import com.codegym.form_user.dto.UserDto;
import com.codegym.form_user.model.User;
import com.codegym.form_user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<User> list = iUserService.getAll(PageRequest.of(page, 5));
        model.addAttribute("listUser", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("user") @Validated UserDto userDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.create(user);
            redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
            return "redirect:/user";
        }

    }

}
