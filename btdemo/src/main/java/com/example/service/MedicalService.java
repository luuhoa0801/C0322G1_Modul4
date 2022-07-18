package com.example.service;

import com.example.model.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.IMedicalRepository;

import java.util.List;

@Service
public class MedicalService implements IMedicalService{

    @Autowired
    private IMedicalRepository iMedicalRepository;
    @Override
    public List<Integer> year() {
        return iMedicalRepository.year();
    }

    @Override
    public List<String> travel() {
        return iMedicalRepository.travel();
    }

    @Override
    public List<String> startDay() {
        return iMedicalRepository.startDay();
    }

    @Override
    public List<String> endDay() {
        return iMedicalRepository.endDay();
    }

    @Override
    public List<Medical> fillAll() {
        return iMedicalRepository.fillAll();
    }

    @Override
    public void save(Medical medical) {
        iMedicalRepository.save(medical);
    }

    @Override
    public Medical findById(int id) {
        return iMedicalRepository.findById(id);
    }

    @Override
    public void update(int id, Medical medical) {
        iMedicalRepository.update(id, medical);
    }
}
