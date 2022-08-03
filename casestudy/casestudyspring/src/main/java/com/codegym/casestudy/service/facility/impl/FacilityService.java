package com.codegym.casestudy.service.facility.impl;

import com.codegym.casestudy.model.facility.Facility;
import com.codegym.casestudy.repository.facility.IFacilityRepository;
import com.codegym.casestudy.repository.facility.IFacilityTypeRepository;
import com.codegym.casestudy.repository.facility.IRentTypeRepository;
import com.codegym.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public Page<Facility> getAll(String name,Pageable pageable) {
        return iFacilityRepository.findAllFacility("%"+name+"%",pageable);
    }

    @Override
    public void create(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iFacilityRepository.delete(id);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

}
