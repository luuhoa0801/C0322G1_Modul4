package com.codegym.ss7_c0222g1.controller;

import com.codegym.ss7_c0222g1.model.Blog;
import com.codegym.ss7_c0222g1.model.Category;
import com.codegym.ss7_c0222g1.service.IBlogService;
import com.codegym.ss7_c0222g1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog() {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCatagory() {
        List<Category> listCate = iCategoryService.findAll();
        if (listCate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCate, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        iBlogService.create(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> view(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("{idCategory}/viewCate")
    public Set<Blog> viewBlog(@PathVariable Integer idCategory) {
        Set<Blog> listBlog = iCategoryService.search(idCategory).getBlog();
        return listBlog;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        Blog blogCurrent = iBlogService.findById(id);
        if (blogCurrent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogCurrent.setTitle(blog.getTitle());
        blogCurrent.setCreateDay(blog.getCreateDay());
        blogCurrent.setCategory(blog.getCategory());
        iBlogService.update(blogCurrent);
        return new ResponseEntity<>(blogCurrent, HttpStatus.OK);
    }

    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable int id) {
        Blog blogDelete = iBlogService.findById(id);
        if (blogDelete == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.delete(id);
        return new ResponseEntity<>(blogDelete, HttpStatus.OK);
    }

}
