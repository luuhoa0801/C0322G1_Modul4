package com.example.model;

public class Medical {
    private String name;
    private String age;
    private String gender;
    private String languages;
    private String idCard;
    private String travel;
    private String vehicleNumber;
    private int callNumber;
    private String startDay;
    private String endDate;
    private String status;

    public Medical() {
    }

    public Medical(String name, String age, String gender, String languages, String idCard,
                   String travel, String vehicleNumber, int callNumber, String startDay,
                   String endDate, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.languages = languages;
        this.idCard = idCard;
        this.travel = travel;
        this.vehicleNumber = vehicleNumber;
        this.callNumber = callNumber;
        this.startDay = startDay;
        this.endDate = endDate;
        this.status = status;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
