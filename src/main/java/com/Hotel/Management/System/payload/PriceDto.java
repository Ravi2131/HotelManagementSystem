package com.Hotel.Management.System.payload;



import java.math.BigDecimal;


public class PriceDto {

    private String hotelName;

    private String roomTypes;

    private BigDecimal priceOfRooms;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
    }

    public BigDecimal getPriceOfRooms() {
        return priceOfRooms;
    }

    public void setPriceOfRooms(BigDecimal priceOfRooms) {
        this.priceOfRooms = priceOfRooms;
    }
}
