package com.codegym.product.service;

import com.codegym.product.model.Product;
import com.codegym.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(String name, Pageable pageable) {
        return iProductRepository.findAllProduct("%" + name + "%", pageable);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.create(product.getName(), product.getPrice(), product.getStatus(), product.getProducer());
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product.getName(), product.getPrice(), product.getStatus(),
                product.getProducer(), product.getId());
    }


}
