package com.codegym.casestudy.service.facility;

import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAllFacilityType();

}
