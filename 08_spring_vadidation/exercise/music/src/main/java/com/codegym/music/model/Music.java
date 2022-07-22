package com.codegym.music.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String showMan;

    private String category;

    public Music() {
    }

    public Music(Integer id, String name, String showMan, String category) {
        this.id = id;
        this.name = name;
        this.showMan = showMan;
        this.category = category;
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

    public String getShowMan() {
        return showMan;
    }

    public void setShowMan(String showMan) {
        this.showMan = showMan;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
