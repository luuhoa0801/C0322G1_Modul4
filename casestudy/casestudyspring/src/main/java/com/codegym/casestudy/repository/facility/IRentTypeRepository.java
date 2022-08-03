package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
    @Query(value = "select * from rent_type ",nativeQuery = true)
    List<RentType> findAllRentType();
}
