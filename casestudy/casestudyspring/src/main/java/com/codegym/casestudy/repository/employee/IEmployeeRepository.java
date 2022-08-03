package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where `name` like :name and status = 0", nativeQuery = true)
    Page<Employee> findAllEmployee(@Param("name")String name, Pageable pageable);

//    @Query(value = "select * from employee where id = :id", nativeQuery = true)
//    Employee findById(@Param("id") int id);

    @Modifying
    @Query(value = "update employee set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

}

