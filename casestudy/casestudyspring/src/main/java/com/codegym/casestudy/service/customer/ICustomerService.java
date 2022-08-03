package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> getAll(Pageable pageable);

    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);

    Optional<Customer> findById(int id);

    List<CustomerType> customerTypeList();

    void update(Customer customer);

    List<Customer> findByName(String name);

}
