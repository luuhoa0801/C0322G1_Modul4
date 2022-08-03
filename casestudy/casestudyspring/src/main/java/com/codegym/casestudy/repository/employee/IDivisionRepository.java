package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
    @Query(value = "select * from division ",nativeQuery = true)
    List<Division> findAllDivision();
}
