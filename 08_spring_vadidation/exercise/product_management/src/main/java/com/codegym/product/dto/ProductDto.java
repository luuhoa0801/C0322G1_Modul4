package com.codegym.product.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto {
    private Integer id;

    @Pattern(regexp = "^[A-Za-z-0-9]*$", message = "sai định dạng name ")
    @Size(min = 1, max = 800, message = "không quá 1-800 từ và không để trống")
    private String name;

    @Min(value = 1, message = "Gía không âm và không để trống")
    private double price;

    @Size(min = 1, max = 300, message = "không quá 300,k để trống")
    private String status;

    @Size(min = 1, max = 300, message = "không quá 300,k để trống")
    private String producer;

    private int statusDelete;

    public ProductDto() {
    }


    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
