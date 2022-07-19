package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static Map<Integer, Product> listProduct;
    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"ip1",1000.0,"co","apple"));
        listProduct.put(2,new Product(2,"ip2",1000.0,"co","apple"));
        listProduct.put(3,new Product(3,"alo",1000.0,"co","apple"));
    }
    @Override
    public List<Product> fillAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
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

    @Override
    public void delete(int id) {
    listProduct.remove(id);
    }
}
