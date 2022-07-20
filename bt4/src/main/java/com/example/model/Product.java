package com.example.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "product_mo")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String status;
    private String producer;
    @ColumnDefault("0")
    @Column(name = "status_delete")
    private int statusDelete;
    public Product() {
    }

    public Product(int id, String name, double price, String status, String producer, int statusDelete) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.producer = producer;
        this.statusDelete = statusDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
