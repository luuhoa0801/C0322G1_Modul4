package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("/blog")
//    public String getShowForm(@RequestParam(value = "title", defaultValue = "") String title,
//                              @RequestParam(name = "page", defaultValue = "0") int page,
//                              Model model) {
//        Sort sort = Sort.by("create_day").descending();
//        Page<Blog> list = iBlogService.findByTitle(title, PageRequest.of(page, 2, sort));
//        Blog blog = new Blog();
//        blog.setTitle(title);
//        model.addAttribute("listBlog", list);
//        model.addAttribute("blog", blog);
//        model.addAttribute("title", title);
//        return "list";
//    }
    @GetMapping("/blog")
    public String showForm(@PageableDefault(value = 2,sort = "create_day",direction = Sort.Direction.ASC)Pageable pageable,
                           @RequestParam(value = "title",defaultValue = "") String title,Model model){
        model.addAttribute("listBlog",iBlogService.findByTitle(title,pageable));
        model.addAttribute("title",title);
        return "list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String save(Blog blog) {
        iBlogService.create(blog.getTitle(), blog.getCreateDay(), blog.getCategory().getIdCategory());
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog) {
        iBlogService.delete(blog.getId());
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        List<Category> categoryList = iBlogService.categoryList();
        model.addAttribute("categoryList", categoryList);
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

}
