package com.example.service;

import com.example.model.Email;
import com.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> listLanguages() {
        List<String> listLanguages = new ArrayList<>();
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        return listLanguages;
    }

    @Override
    public List<Integer> listSize() {
        List<Integer> listSize = new ArrayList<>();
        listSize.add(5);
        listSize.add(10);
        listSize.add(15);
        listSize.add(25);
        listSize.add(50);
        listSize.add(100);
        return listSize;
    }

    @Override
    public List<Email> fillAll() {
        return iEmailRepository.fillAll();
    }

    @Override
    public void save(Email email) {
        iEmailRepository.save(email);
    }

}
