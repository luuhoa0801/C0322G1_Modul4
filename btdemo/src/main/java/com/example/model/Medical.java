package com.example.model;

public class Medical {
    private Integer id;
    private String name;
    private String age;
    private String travel;
    private String startDay;
    private String endDay;
    private String status;

    public Medical() {
    }

    public Medical(Integer id, String name, String age, String travel, String startDay, String endDay, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.travel = travel;
        this.startDay = startDay;
        this.endDay = endDay;
        this.status = status;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
