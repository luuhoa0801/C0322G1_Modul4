package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllType();


}
