package com.codegym.blog.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "create_day")
    private String createDay;
    @Column(name = "status_delete")
    @ColumnDefault("0")
    private int statusDelete;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(String title, String createDay, int statusDelete, Category category) {
        this.title = title;
        this.createDay = createDay;
        this.statusDelete = statusDelete;
        this.category = category;
    }

    public Blog(String title, String createDay, int statusDelete) {
        this.title = title;
        this.createDay = createDay;
        this.statusDelete = statusDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
