package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.facility.FacilityType;
import com.codegym.casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
    @Query(value = "select * from facility_type ",nativeQuery = true)
    List<FacilityType> findAllFacilityType();
}
