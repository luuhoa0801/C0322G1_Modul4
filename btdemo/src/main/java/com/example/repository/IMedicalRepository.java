package com.example.repository;

import com.example.model.Medical;

import java.util.List;

public interface IMedicalRepository {
    List<Integer> year ();

    List<String> travel();

    List<String> startDay();

    List<String> endDay();

    List<Medical> fillAll();

    void save(Medical medical);

    Medical findById(int id);

    void update(int id,Medical medical);

}
