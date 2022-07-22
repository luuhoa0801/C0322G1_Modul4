package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);

    void create(Product product);

    void update(Product product);

    Product findByIdSearch(Integer id);

    void delete(Integer id);
}
