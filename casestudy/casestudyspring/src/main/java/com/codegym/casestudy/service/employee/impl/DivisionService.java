package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.repository.employee.IDivisionRepository;
import com.codegym.casestudy.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAllDivision();
    }
}
