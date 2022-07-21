package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(String name, Pageable pageable);

    Product findById(int id);

    void save(Product product);

    void delete(int id);

    void update(Product product);

}
