package com.codegym.casestudy.service.facility;

import com.codegym.casestudy.model.facility.RentType;
import com.codegym.casestudy.service.facility.impl.RentTypeService;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAllRentType();

}
