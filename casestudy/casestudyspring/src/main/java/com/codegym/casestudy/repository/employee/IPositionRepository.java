package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IPositionRepository extends JpaRepository<Position,Integer> {
    @Query(value = "select * from position ",nativeQuery = true)
    List<Position> findAllPosition();
}
