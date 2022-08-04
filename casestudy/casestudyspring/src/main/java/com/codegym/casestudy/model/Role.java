//package com.codegym.casestudy.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<AppUser> users;
//
//    public Role() {
//    }
//
//    public Role(Set<AppUser> users) {
//        this.users = users;
//    }
//
//    public Role(Integer id, String name, Set<AppUser> users) {
//        this.id = id;
//        this.name = name;
//        this.users = users;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<AppUser> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<AppUser> users) {
//        this.users = users;
//    }
//}
