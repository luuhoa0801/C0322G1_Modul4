package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAllType() {
        return iCustomerTypeRepository.findAllCustomerType();
    }

}
