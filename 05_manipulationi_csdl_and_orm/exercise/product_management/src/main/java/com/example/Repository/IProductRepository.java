package com.example.Repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> searchByName(String name);

}

