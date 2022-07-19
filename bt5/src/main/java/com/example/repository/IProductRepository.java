package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> fillAll();

    Product findById(int id);

    void delete(int id);
}
