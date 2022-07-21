package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(String title, String createDay);

    void delete(int id);

    Blog findById(int id);

    void update(String title, String createDay, int id);
}
