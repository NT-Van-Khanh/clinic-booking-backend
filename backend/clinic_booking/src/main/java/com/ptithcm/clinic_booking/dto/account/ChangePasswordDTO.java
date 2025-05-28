package com.ptithcm.clinic_booking.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangePasswordDTO {
    @Schema(description = "Tên đăng nhập của tài khoản",
            example = "manager1", minLength = 8, maxLength = 100)
    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(min = 8, max = 100, message = "Tên đăng nhập phải từ 8 đến 50 ký tự")
    private String username;

    @Schema(description = "Mật khẩu hiện tại",
            example = "Abc@123456",  minLength = 8, maxLength = 255 )
    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 8, max = 255, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String currentPassword;

    @Schema(description = "Mật khẩu mới",
            example = "Abc@123456",  minLength = 8, maxLength = 255 )
    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 8, max = 255, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String newPassword;

    public ChangePasswordDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
