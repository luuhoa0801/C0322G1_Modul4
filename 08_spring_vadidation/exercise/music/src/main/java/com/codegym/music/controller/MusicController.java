package com.codegym.music.controller;

import com.codegym.music.model.Music;
import com.codegym.dto.MusicDto;
import com.codegym.music.service.IMusicService;
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

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/music")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Music> list = iMusicService.getAll(PageRequest.of(page, 5));
        model.addAttribute("listMusic", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("music") @Validated MusicDto musicDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            iMusicService.create(music);
            redirectAttributes.addFlashAttribute("msg", "thêm mới thành công" + music.getName());
            return "redirect:/music";
        }
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("music", iMusicService.findByIdSearch(id));
        return "edit";
    }

    @PostMapping("/update")
    public String PostUpdate( @ModelAttribute(name = "music") @Validated MusicDto musicDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            iMusicService.update(music);
            redirectAttributes.addFlashAttribute("msg", "chỉnh sửa thành công");
            return "redirect:/music";
        }


    }

}
