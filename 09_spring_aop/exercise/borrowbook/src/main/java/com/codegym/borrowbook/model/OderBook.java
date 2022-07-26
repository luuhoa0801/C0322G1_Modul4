package com.codegym.borrowbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "oder_book")
public class OderBook {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id_book")
    private Book books;

    public OderBook() {
    }

    public OderBook(String id, Book books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }
}
