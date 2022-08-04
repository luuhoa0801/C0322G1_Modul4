package com.codegym.casestudy.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "user")
public class User {
    @Id
    @Column(name = "username")
    private String userName;

    private String passWord;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public User(String userName, String passWord, Employee employee) {
        this.userName = userName;
        this.passWord = passWord;
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
