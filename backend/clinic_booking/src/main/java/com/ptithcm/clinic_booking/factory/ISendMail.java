package com.ptithcm.clinic_booking.factory;

public interface ISendMail<T> {
    void sendOtpToEmail(String email, T data);
}
