package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> fillAll();

    Product findById(int id);

    List<Product> searchByName(String name);

    void delete(int id);

}
