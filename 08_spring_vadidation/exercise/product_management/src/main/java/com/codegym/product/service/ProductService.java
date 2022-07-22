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
    public Page<Product> getAll(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product.getName(), product.getPrice(), product.getStatus(), product.getProducer());
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product.getName(), product.getPrice(), product.getStatus(), product.getProducer(), product.getId());
    }

    @Override
    public Product findByIdSearch(Integer id) {
        return iProductRepository.findByIdSearch(id);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }
}
