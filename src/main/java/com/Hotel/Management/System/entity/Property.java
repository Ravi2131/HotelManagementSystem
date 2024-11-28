package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "no_of_guests", nullable = false)
    private Integer noOfGuests;

    @Column(name = "no_of_bedrooms", nullable = false)
    private Integer noOfBedrooms;

    @Column(name = "no_of_beds", nullable = false)
    private Integer noOfBeds;

    @Column(name = "no_of_bathrooms", nullable = false)
    private Integer noOfBathrooms;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State stateId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location locationId;

    @Column(name = "pin_code", nullable = false, unique = true)
    private Integer pinCode;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotelId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price priceId;

//    @OneToMany(mappedBy = "propertyId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Review> reviews;
//
//    @OneToMany(mappedBy = "propertyId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Images> images;
//
//    @OneToMany(mappedBy = "propertyId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Bookings> bookings;
//
//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<RoomAvailability> roomAvailabilities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(Integer noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public Integer getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(Integer noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public Integer getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(Integer noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public Integer getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(Integer noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Hotels getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotels hotelId) {
        this.hotelId = hotelId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Price getPriceId() {
        return priceId;
    }

    public void setPriceId(Price priceId) {
        this.priceId = priceId;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public List<Images> getImages() {
//        return images;
//    }
//
//    public void setImages(List<Images> images) {
//        this.images = images;
//    }
//
//    public List<Bookings> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Bookings> bookings) {
//        this.bookings = bookings;
//    }
//
//    public List<RoomAvailability> getRoomAvailabilities() {
//        return roomAvailabilities;
//    }
//
//    public void setRoomAvailabilities(List<RoomAvailability> roomAvailabilities) {
//        this.roomAvailabilities = roomAvailabilities;
//    }
}