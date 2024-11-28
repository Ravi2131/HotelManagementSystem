package com.Hotel.Management.System.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "room_availability")
public class RoomAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "available_rooms", nullable = false)
    private Integer availableRooms;

    @Version
    private long versions;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    private Dates datesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public long getVersions() {
        return versions;
    }

    public void setVersions(long versions) {
        this.versions = versions;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Dates getDatesId() {
        return datesId;
    }

    public void setDatesId(Dates datesId) {
        this.datesId = datesId;
    }
}
