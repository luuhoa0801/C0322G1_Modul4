package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.repository.employee.IEmployeeRepository;
import com.codegym.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllEmployee(String name, Pageable pageable) {
        return iEmployeeRepository.findAllEmployee("%"+name+"%",pageable);
    }

    @Override
    public void create(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepository.delete(id);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
