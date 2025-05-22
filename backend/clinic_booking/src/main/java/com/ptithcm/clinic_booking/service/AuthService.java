package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.auth.AuthResponseDTO;

public interface AuthService{
    AuthResponseDTO login(String username, String password);
//    UserDetails loadUserByUsername(String username);

    void logout();
    void changePassword(String username, String currentPassword, String newPassword);
    void sendOtpToEmail(String email);
    void resetPassword(String email, String otp, String newPassword);
}
