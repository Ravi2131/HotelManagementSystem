package com.Hotel.Management.System.payload;



import java.math.BigDecimal;
import java.util.Date;


public class BookingDto {

    private String noOfAdults;

    private String noOfChildren;

    private String noOfRooms;

    private String bookingDate;

    private Date checkIn;

    private Date checkOut;

    private BigDecimal totalPrice;

    private String bookingCode;

    private AppUserDto appUserId;

    private PropertyDto propertyId;

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public AppUserDto getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(AppUserDto appUserId) {
        this.appUserId = appUserId;
    }

    public PropertyDto getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(PropertyDto propertyId) {
        this.propertyId = propertyId;
    }
}
