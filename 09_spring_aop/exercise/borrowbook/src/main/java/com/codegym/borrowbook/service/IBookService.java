package com.codegym.borrowbook.service;

import com.codegym.borrowbook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> getAll(Pageable pageable);

    Book findByCodeBook(String idBook);

    void update(Book book);

    void returnBook(Book book);
}
