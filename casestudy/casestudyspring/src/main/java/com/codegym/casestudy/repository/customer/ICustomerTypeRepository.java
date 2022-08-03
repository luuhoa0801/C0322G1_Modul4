package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface ICustomerTypeRepository  extends JpaRepository<CustomerType,Integer > {

    @Query(value = "select * from customer_type ",nativeQuery = true)
    List<CustomerType> findAllCustomerType();

}
