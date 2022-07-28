package com.codegym.ss7_c0222g1.service;

import com.codegym.ss7_c0222g1.model.Blog;
import com.codegym.ss7_c0222g1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void create(Blog blog);

    void delete(Integer id);

    Blog findById(int id);

    void update(Blog blog);

    List<Category> categoryList();

    List<Blog> findAll();


}
