package com.codegym.product.repository;


import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where status_delete = 0", nativeQuery = true)
    Page<Product> findAllProduct(Pageable pageable);

    @Modifying
    @Query(value = "insert into product (name,price,status,producer) values " +
            "(:name,:price,:status,:producer)", nativeQuery = true)
    void create(@Param("name") String name, @Param("price") double price,
                @Param("status") String status, @Param("producer") String producer);

    @Modifying
    @Query(value = "update product set name =:name,price =:price, status = :status,producer =:producer where id =:id")
    void update(@Param("name") String name, @Param("price") double price, @Param("status") String status, @Param("producer") String producer,
                @Param("id") Integer id);

    @Modifying
    @Query(value = "update product  set status_delete = 1 where id = :id ", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findByIdSearch(@Param("id") Integer id);



}
