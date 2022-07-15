package com.example.repository;

import com.example.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailRepository implements IEmailRepository {
    List<Email> emailList = new ArrayList<>();

    @Override
    public List<Email> fillAll() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }
}
