package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location locationId;

//    @OneToMany(mappedBy = "hotelId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Price> prices;
//
//    @OneToMany(mappedBy = "hotelId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

//    public List<Price> getPrices() {
//        return prices;
//    }
//
//    public void setPrices(List<Price> prices) {
//        this.prices = prices;
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