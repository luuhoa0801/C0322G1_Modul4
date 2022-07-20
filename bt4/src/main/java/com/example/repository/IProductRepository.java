package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> fillAll();

    Product findById(int id);

    void delete(int id);

    void update(Product product);

    void save(Product product);

    List<Product> searchByName(String name);

}
