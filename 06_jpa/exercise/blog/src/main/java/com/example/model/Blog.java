package com.example.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(name = "create_day")
    private String createDay;
    @Column(name = "status_delete")
    @ColumnDefault("0")
    private int statusDelete;

    public Blog() {
    }

    public Blog(String title, String createDay, int statusDelete) {
        this.title = title;
        this.createDay = createDay;
        this.statusDelete = statusDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

}
