package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> fillAll();

    Product findById(int id);

    List<Product> searchByName(String name);

    void delete(int id);
}
