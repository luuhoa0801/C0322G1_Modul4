package com.codegym.borrowbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @Column(name = "id_book")
    private String idBook;

    @Column(name = "name_book")
    private String nameBook;
    private int amount;

    @OneToMany(mappedBy = "books")
    private Set<OderBook> oderBooks;

    public Book() {
    }

    public Book(String idBook, String nameBook, int amount, Set<OderBook> oderBooks) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.amount = amount;
        this.oderBooks = oderBooks;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<OderBook> getOderBooks() {
        return oderBooks;
    }

    public void setOderBooks(Set<OderBook> oderBooks) {
        this.oderBooks = oderBooks;
    }

}
