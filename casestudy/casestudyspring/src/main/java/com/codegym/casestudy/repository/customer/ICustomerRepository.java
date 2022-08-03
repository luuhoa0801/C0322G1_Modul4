package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface ICustomerRepository  extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where status = 0",nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Query(value = "select * from customer where name like :name ", nativeQuery = true)
    List<Customer> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "update customer set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);
}
