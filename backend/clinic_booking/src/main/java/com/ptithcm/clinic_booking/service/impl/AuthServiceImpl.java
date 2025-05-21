package com.ptithcm.clinic_booking.service.impl;

import com.ptithcm.clinic_booking.config.JwtUtil;
import com.ptithcm.clinic_booking.dto.doctor.DoctorDTO;
import com.ptithcm.clinic_booking.dto.manager.ManagerResponseDTO;
import com.ptithcm.clinic_booking.dto.account.AuthResponse;
import com.ptithcm.clinic_booking.mapper.DoctorMapper;
import com.ptithcm.clinic_booking.mapper.ManagerMapper;
import com.ptithcm.clinic_booking.model.*;
import com.ptithcm.clinic_booking.repository.AccountRepository;
import com.ptithcm.clinic_booking.repository.DoctorRepository;
import com.ptithcm.clinic_booking.repository.ManagerRepository;
import com.ptithcm.clinic_booking.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final DoctorRepository doctorRepository;
    private final ManagerRepository managerRepository;

    public AuthServiceImpl(JwtUtil jwtUtil,
                           AuthenticationManager authenticationManager,
                           AccountRepository accountRepository,
                           DoctorRepository doctorRepository,
                           ManagerRepository managerRepository) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.accountRepository = accountRepository;
        this.doctorRepository = doctorRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public AuthResponse login(String username, String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.err.println(passwordEncoder.encode(password));
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        UserDetails userDetails =(UserDetails) authentication.getPrincipal();
        String authToken = jwtUtil.generateToken(userDetails);

        AuthResponse authResponse = new AuthResponse();
        
        if (userDetails instanceof DoctorDetails doctorDetails) {
            DoctorDTO doctorDTO = DoctorMapper.toDoctorDTO(doctorDetails.getDoctor());
            authResponse.setUserData(doctorDTO);
        } else if (userDetails instanceof ManagerDetails managerDetails) {
            ManagerResponseDTO managerDTO = ManagerMapper.toManagerDTO(managerDetails.getManager());
            authResponse.setUserData(managerDTO);
        }
        authResponse.setToken(authToken);
        return authResponse;
    }

    @Override
    public void logout() {

    }

    @Override
    public void changePassword(String username, String currentPassword, String newPassword) {

    }

    @Override
    public void sendOtpToEmail(String email) {

    }

    @Override
    public void resetPassword(String email, String otp, String password) {

    }
}
