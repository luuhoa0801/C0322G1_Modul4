package com.codegym.casestudy.service.facility;

import com.codegym.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> getAll(String name,Pageable pageable);

    void create(Facility facility);

    void update(Facility facility);

    Optional<Facility> findById(int id);

    void  delete(int id);

    List<Facility> findAll();

}
