package com.codegym.blog_ajax.service;

import com.codegym.blog_ajax.model.Blog;
import com.codegym.blog_ajax.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    void create(String title, String createDay, Integer idCategory);

    void delete(Integer id);

    Blog findById(int id);

    void update(Blog blog);

    Page<Blog> getAll(Pageable pageable);

    List<Category> categoryList();

    Page<Blog> findByTitle(String title, Pageable pageable);

    List<Blog> findByName(String title);
}
