package com.codegym.casestudy.service.facility.impl;

import com.codegym.casestudy.model.facility.FacilityType;
import com.codegym.casestudy.repository.facility.IFacilityRepository;
import com.codegym.casestudy.repository.facility.IFacilityTypeRepository;
import com.codegym.casestudy.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAllFacilityType() {
        return iFacilityTypeRepository.findAllFacilityType();
    }
}
