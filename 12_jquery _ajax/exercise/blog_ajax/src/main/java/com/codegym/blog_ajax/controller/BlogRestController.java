package com.codegym.blog_ajax.controller;

import com.codegym.blog_ajax.model.Blog;
import com.codegym.blog_ajax.service.IBlogService;
import com.codegym.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> searchById(@PathVariable String title) {
        List<Blog> blog = iBlogService.findByName(title);
        if (blog==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


}
