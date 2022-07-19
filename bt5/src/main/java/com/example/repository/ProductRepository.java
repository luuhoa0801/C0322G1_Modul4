package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> fillAll() {
List<Product>productList = BaseRepository.entityManager.createQuery
        ("select  p from product_demo p",Product.class).getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.createQuery
                ("select p from product_demo where id =?1 ",Product.class).setParameter(1,id).getSingleResult();
        return product;
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
