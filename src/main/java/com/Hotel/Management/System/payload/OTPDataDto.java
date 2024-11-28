package com.Hotel.Management.System.payload;




public class OTPDataDto {

    private final String otp;

    private final long expiryTime;

    public String getOtp() {
        return otp;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public OTPDataDto(String otp, long expiryTime) {
        this.otp = otp;
        this.expiryTime = expiryTime;


    }

}
