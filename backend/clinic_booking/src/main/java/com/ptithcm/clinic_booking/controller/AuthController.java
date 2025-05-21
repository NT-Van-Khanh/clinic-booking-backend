package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.account.LoginRequestDTO;
import com.ptithcm.clinic_booking.dto.account.AuthResponse;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Validated
public class AuthController {

    private final AuthService accountService;

    @Autowired
    public AuthController(AuthService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody @Valid LoginRequestDTO user){
        AuthResponse authResponse = accountService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, authResponse));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(){
        accountService.logout();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Đăng xuất thành công"));
    }
}
