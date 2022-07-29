package com.codegym.blog_ajax.service;

import com.codegym.blog_ajax.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
