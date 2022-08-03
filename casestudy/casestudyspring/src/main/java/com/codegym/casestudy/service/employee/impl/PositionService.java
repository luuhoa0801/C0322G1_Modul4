package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.repository.employee.IPositionRepository;
import com.codegym.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAllPosition();
    }
}
