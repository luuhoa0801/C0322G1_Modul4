package com.example.Repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery
                ("select p from product p where statusDelete = 0", Product.class).getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.createQuery
                ("select p from product p where id=?1", Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        product.setStatusDelete(1);
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchList = BaseRepository.entityManager.createQuery
                ("select p from product p where name like ?1 ", Product.class).setParameter(1, "%" + name + "%").getResultList();
        return searchList;
    }
}
