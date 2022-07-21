package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> listLanguages();

    List<Integer> listSize();

    List<Email> fillAll();

    void save(Email email);
}
