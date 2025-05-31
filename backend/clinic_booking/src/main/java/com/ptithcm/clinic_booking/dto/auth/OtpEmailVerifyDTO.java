package com.ptithcm.clinic_booking.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OtpEmailVerifyDTO {
    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    @Schema(description = "Email tài khoản", example = "doctor@example.com")
    private String email;

    @Size(min = 6, max = 6)
    @NotBlank(message = "OTP không được để trống")
    @Schema(description = "Email tài khoản", example = "999999")
    private String otp;

    public OtpEmailVerifyDTO() {
    }

    public @Email(message = "Email không hợp lệ") @NotBlank(message = "Email không được để trống") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email không hợp lệ") @NotBlank(message = "Email không được để trống") String email) {
        this.email = email;
    }

    public @Size(min = 6, max = 6) @NotBlank(message = "OTP không được để trống") String getOtp() {
        return otp;
    }

    public void setOtp(@Size(min = 6, max = 6) @NotBlank(message = "OTP không được để trống") String otp) {
        this.otp = otp;
    }
}
