package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price_of_rooms", nullable = false, precision = 10, scale = 2, unique = true)
    private BigDecimal priceOfRooms;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "hotels_id")
    private Hotels hotelId;

//    @OneToMany(mappedBy = "priceId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPriceOfRooms() {
        return priceOfRooms;
    }

    public void setPriceOfRooms(BigDecimal priceOfRooms) {
        this.priceOfRooms = priceOfRooms;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Hotels getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotels hotelId) {
        this.hotelId = hotelId;
    }

//    public List<Property> getProperties() {
//        return properties;
//    }
//
//    public void setProperties(List<Property> properties) {
//        this.properties = properties;
//    }
}