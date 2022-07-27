package com.codegym.cart.service;

import com.codegym.cart.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICartService {
    Page<Cart> getAll(Pageable pageable);

    Cart findById(Integer id);

    void delete(int idCart);
}
