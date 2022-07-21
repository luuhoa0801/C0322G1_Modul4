package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/music")
    public String getShowForm(Model model) {
        model.addAttribute("listMusic", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("create")
    public String save(Music music) {
        iMusicService.create(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        iMusicService.update(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music) {
        iMusicService.delete(music.getId());
        return "redirect:/music";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model) {
        model.addAttribute("listMusic", iMusicService.searchByName(name));
        return "list";
    }


}
