package com.codegym.product.repository;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findById(@Param("id") int id);

    @Query(value = "select * from product where name like :name and status_delete = 0 ", nativeQuery = true)
    Page<Product> findAllProduct(String name, Pageable pageable);

    @Query(value = "select * from product where status_delete = 0", nativeQuery = true)
    List<Product> findAll();

    @Modifying
    @Query(value = "update product set status_delete = 1 where id = :id ", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product set name =:name, price =:price, status =:status," +
            "producer =:producer where id =:id",
            nativeQuery = true)
    void update(@Param("name") String name, @Param("price") double price,
                @Param("status") String status, @Param("producer") String producer, @Param("id") Integer id);

    @Modifying
    @Query(value = "insert into product (name,price,status,producer) values " +
            "(:name,:price,:status,:producer)", nativeQuery = true)
    void create(@Param("name") String name,
                @Param("price") double price,
                @Param("status") String status,
                @Param("producer") String producer);

//    @Query(value = "select * from product where name like :name ", nativeQuery = true)
//    Page<Product> findByName(@Param("name") String name, Pageable pageable);

}

