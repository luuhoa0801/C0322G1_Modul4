package com.example.service;

import com.example.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository medicalRepository;

    @Override
    public List<Integer> yearSer() {
        return medicalRepository.year();
    }

    @Override
    public List<String> genderSer() {
        return medicalRepository.gender();
    }

    @Override
    public List<String> languagesSer() {
        return medicalRepository.languages();
    }
}
