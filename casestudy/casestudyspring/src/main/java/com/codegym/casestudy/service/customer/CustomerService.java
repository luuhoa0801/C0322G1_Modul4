package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
    iCustomerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.delete(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public List<CustomerType> customerTypeList() {
        return iCustomerTypeRepository.findAllCustomerType();    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findByName("%" + name +"%");
    }

}
