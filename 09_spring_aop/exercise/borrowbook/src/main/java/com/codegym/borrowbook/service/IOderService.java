package com.codegym.borrowbook.service;

import com.codegym.borrowbook.model.OderBook;

public interface IOderService {
    void create(String id, String idBook);

    OderBook findIdOder(String id);

    void delete(OderBook oderBook);
}
