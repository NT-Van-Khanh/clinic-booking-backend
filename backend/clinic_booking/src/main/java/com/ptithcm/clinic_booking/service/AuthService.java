package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.account.AuthResponse;
import com.ptithcm.clinic_booking.model.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService{
    AuthResponse login(String username, String password);
//    UserDetails loadUserByUsername(String username);

    void logout();
    void changePassword(String username, String currentPassword, String newPassword);
    void sendOtpToEmail(String email);
    void resetPassword(String email, String otp, String password);
}
