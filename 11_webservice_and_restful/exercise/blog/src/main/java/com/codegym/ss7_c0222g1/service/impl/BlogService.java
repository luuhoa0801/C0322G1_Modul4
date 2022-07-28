package com.codegym.ss7_c0222g1.service.impl;

import com.codegym.ss7_c0222g1.model.Blog;
import com.codegym.ss7_c0222g1.model.Category;
import com.codegym.ss7_c0222g1.repository.IBlogRepository;
import com.codegym.ss7_c0222g1.repository.ICategoryRepository;
import com.codegym.ss7_c0222g1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public void create(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.delete(id);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getTitle(), blog.getCreateDay(), blog.getCategory().getIdCategory(), blog.getId());
    }

    @Override
    public List<Category> categoryList() {
        return iCategoryRepository.findAll();
    }


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

}
