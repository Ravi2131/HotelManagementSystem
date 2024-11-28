package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Column(name = "pin_code", nullable = false)
    private Integer pinCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;

//    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Hotels> hotels;
//
//    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

//    public List<Hotels> getHotels() {
//        return hotels;
//    }
//
//    public void setHotels(List<Hotels> hotels) {
//        this.hotels = hotels;
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