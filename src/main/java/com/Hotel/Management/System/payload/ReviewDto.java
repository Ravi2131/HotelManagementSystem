package com.Hotel.Management.System.payload;


public class ReviewDto {

    private int ratings;

    private String description;

    private AppUserDto appUserDto;

    private PropertyDto propertyDto;

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUserDto getAppUserDto() {
        return appUserDto;
    }

    public void setAppUserDto(AppUserDto appUserDto) {
        this.appUserDto = appUserDto;
    }

    public PropertyDto getPropertyDto() {
        return propertyDto;
    }

    public void setPropertyDto(PropertyDto propertyDto) {
        this.propertyDto = propertyDto;
    }
}

