package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> fillAll();

    Product findById(int id);

    void delete(int id);
}
