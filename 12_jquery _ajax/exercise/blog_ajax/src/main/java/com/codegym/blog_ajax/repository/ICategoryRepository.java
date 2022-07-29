package com.codegym.blog_ajax.repository;

import com.codegym.blog_ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
