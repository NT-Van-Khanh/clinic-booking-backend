package com.ptithcm.clinic_booking.util;

public class OTPUtil {

    public static String generateOtp() {
        int randomOtp = (int)(Math.random() * 900000) + 100000;
        return String.valueOf(randomOtp);
    }
}
