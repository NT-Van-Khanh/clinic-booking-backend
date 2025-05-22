package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.auth.EmailRequestDTO;
import com.ptithcm.clinic_booking.dto.auth.LoginRequestDTO;
import com.ptithcm.clinic_booking.dto.auth.AuthResponseDTO;
import com.ptithcm.clinic_booking.dto.auth.ResetPasswordRequestDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.AuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/p/auth")
@Validated
public class AuthController {

    private final AuthService accountService;

    @Autowired
    public AuthController(AuthService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> login(@RequestBody @Valid LoginRequestDTO user){
        AuthResponseDTO authResponse = accountService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, authResponse));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(){
        accountService.logout();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Đăng xuất thành công"));
    }

    @PostMapping("/reset-password/send-otp/email")
    public ResponseEntity<ApiResponse<String>> sendOtpToEmail(@RequestBody @Valid EmailRequestDTO email){
        accountService.sendOtpToEmail(email.getEmail());
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Gửi OTP thành công"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<String>> resetPassword(@RequestBody @Valid ResetPasswordRequestDTO request){
        accountService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword());
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Khôi phục mật khẩu thành công"));
    }
}
