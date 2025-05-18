package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.DoctorDTO;
import com.ptithcm.clinic_booking.dto.LoginResponseDTO;
import com.ptithcm.clinic_booking.model.Account;

public interface AuthService {
    LoginResponseDTO login(String username, String password);
    void logout();
    void changePassword();
    void sendOtpToEmail(String email);
    void resetPassword(String email, String otp, String password);
}
