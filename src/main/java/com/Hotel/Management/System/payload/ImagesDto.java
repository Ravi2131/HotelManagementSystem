package com.Hotel.Management.System.payload;


public class ImagesDto {

    private String imageUrl;

    private AppUserDto appUserDto;

    private PropertyDto propertyDto;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
