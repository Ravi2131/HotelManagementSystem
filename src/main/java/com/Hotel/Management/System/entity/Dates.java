package com.Hotel.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;


@Entity
@Table(name = "dates")
public class Dates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_lists", nullable = false)
    private Date date_lists;

//    @OneToMany(mappedBy = "datesId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<RoomAvailability> roomAvailabilities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_lists() {
        return date_lists;
    }

    public void setDate_lists(Date date_lists) {
        this.date_lists = date_lists;
    }

//    public List<RoomAvailability> getRoomAvailabilities() {
//        return roomAvailabilities;
//    }
//
//    public void setRoomAvailabilities(List<RoomAvailability> roomAvailabilities) {
//        this.roomAvailabilities = roomAvailabilities;
//    }
}