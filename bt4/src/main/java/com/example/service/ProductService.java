package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> fillAll() {
        return iProductRepository.fillAll();
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }

    @Override
    public void delete(int id) {
    iProductRepository.delete(id);
    }
}
