package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
    @Query(value = "select * from education_degree",nativeQuery = true)
    List<EducationDegree> findAllEducationDegree();
}
