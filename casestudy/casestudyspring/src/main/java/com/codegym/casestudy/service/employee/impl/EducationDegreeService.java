package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.repository.employee.IEducationDegreeRepository;
import com.codegym.casestudy.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAllEducationDegree();
    }
}
