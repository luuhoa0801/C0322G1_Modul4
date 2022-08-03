package com.codegym.casestudy.service.facility.impl;

import com.codegym.casestudy.model.facility.RentType;
import com.codegym.casestudy.repository.facility.IFacilityRepository;
import com.codegym.casestudy.repository.facility.IRentTypeRepository;
import com.codegym.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepository.findAllRentType();
    }
}
