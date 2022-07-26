package com.codegym.borrowbook.service;

import com.codegym.borrowbook.model.OderBook;
import com.codegym.borrowbook.repository.IOderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderBookService implements IOderService {
    @Autowired
    private IOderBookRepository iOderBookRepository;

    @Override
    public void create(String id, String idBook) {
        iOderBookRepository.create(id, idBook);
    }

    @Override
    public OderBook findIdOder(String id) {
        return iOderBookRepository.findByIdOder(id);
    }

    @Override
    public void delete(OderBook oderBook) {
        iOderBookRepository.delete(oderBook);
    }
}
