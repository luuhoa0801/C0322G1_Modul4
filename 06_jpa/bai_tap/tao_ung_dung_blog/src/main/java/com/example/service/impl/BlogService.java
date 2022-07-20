package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void create(String title, String createDay) {
        iBlogRepository.create(title, createDay);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.delete(id);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(String title, String createDay, int id) {
        iBlogRepository.update(title, createDay, id);
    }


}
