package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> fillAll();

    void save(Email email);
}
