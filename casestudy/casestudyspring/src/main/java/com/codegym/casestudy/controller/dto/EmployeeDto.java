package com.codegym.casestudy.controller.dto;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.model.employee.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {
    private int id;

    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "sai định dạng name ")
    @Size(min = 1, max = 800, message = "không quá 1-800 từ và không để trống")
    private String name;

    private String dateOfBirth;

    @Pattern(regexp = "^[1-9]{9}$",message = "CMND 9 số và không để trống")
    private String idCard;

    @Pattern(regexp = "^090[0-9]{7}$", message = "sai định dạng,phải là 090...")
    private String phone;

    @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "sai đinh dạng,phải đúng định dạng email")
    private String email;

    @Min(value = 1,message = "Không âm và không để trống")
    private double salary;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;
    private int status;

    public EmployeeDto() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
