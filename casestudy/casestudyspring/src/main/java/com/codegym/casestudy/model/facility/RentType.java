package com.codegym.casestudy.model.facility;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rentType")
    @JsonIgnore
    private Set<Facility> facilityRent;

    public RentType() {
    }

    public RentType(Integer id, String name, Set<Facility> facilityRent) {
        this.id = id;
        this.name = name;
        this.facilityRent = facilityRent;
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

    public Set<Facility> getFacilityRent() {
        return facilityRent;
    }

    public void setFacilityRent(Set<Facility> facilityRent) {
        this.facilityRent = facilityRent;
    }
}
