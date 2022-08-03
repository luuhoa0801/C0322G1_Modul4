package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(String name, Pageable pageable);

    void create(Employee employee);

    void  delete(int id);

    Optional<Employee> findById(int id);

    void update(Employee employee);

    List<Employee> findAll();
}
