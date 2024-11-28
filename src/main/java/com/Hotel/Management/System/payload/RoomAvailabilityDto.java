package com.Hotel.Management.System.payload;



import java.util.Date;


public class RoomAvailabilityDto {

    private Date date;

    private Integer availableRooms;

    private PropertyDto propertyDto;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public PropertyDto getPropertyDto() {
        return propertyDto;
    }

    public void setPropertyDto(PropertyDto propertyDto) {
        this.propertyDto = propertyDto;
    }
}

