package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.parsing.Location;

import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State stateId;

//    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Location> locations;
//
//    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

//    public List<Location> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<Location> locations) {
//        this.locations = locations;
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