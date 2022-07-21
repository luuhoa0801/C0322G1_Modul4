package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> listProduct;

    static {
        listProduct = new HashMap<>();
        listProduct.put(1, new Product(1, "iphone1", 1000.0, "sẵn sàng", "IP"));
        listProduct.put(2, new Product(2, "iphone2", 2000.0, "sẵn sàng", "IP"));
        listProduct.put(3, new Product(3, "iphone3", 3000.0, "k có sẵn", "IP"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item : listProduct.entrySet()) {
            if (item.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                searchList.add(item.getValue());
            }
        }
        return searchList;
    }
}
