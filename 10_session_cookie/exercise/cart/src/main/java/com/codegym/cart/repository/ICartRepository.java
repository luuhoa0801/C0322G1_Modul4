package com.codegym.cart.repository;

import com.codegym.cart.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "select * from cart ", nativeQuery = true)
    Page<Cart> fillAllCart(Pageable pageable);

    @Query(value = "delete from cart where id_cart =: idCart ", nativeQuery = true)
    void delete(@Param("idCart") Integer idCart);
}
