package com.codegym.blog_ajax.service.impl;

import com.codegym.blog_ajax.model.Category;
import com.codegym.blog_ajax.repository.ICategoryRepository;
import com.codegym.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
