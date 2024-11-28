package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.Property;
import java.util.List;



@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

//    @OneToMany(mappedBy = "stateId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<City> cities;
//
//    @OneToMany(mappedBy = "stateId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

//    public List<City> getCities() {
//        return cities;
//    }
//
//    public void setCities(List<City> cities) {
//        this.cities = cities;
//    }
//
//    public List<Property> getProperties() {
//        return properties;
//    }
//
//    public void setProperties(List<Property> properties) {
//        this.properties = properties;
//    }
}