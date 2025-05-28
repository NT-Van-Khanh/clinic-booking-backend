package com.ptithcm.clinic_booking.dto.account;

import com.ptithcm.clinic_booking.dto.RoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class AccountResponseDTO {
    @Schema(description = "Tên đăng nhập của tài khoản", example = "manager1")
    private String username;

    @Schema( description = "Vai trò của tài khoản (chỉ cho phép MANAGER và DOCTOR)", example = "2")
    private RoleDTO role;

    @Schema( description = "Trạng thái của tài khoản (ACTIVE, BLOCKED hoặc DELETED)",  example = "ACTIVE")
    private String status;
    private LocalDateTime createdAt;

    public AccountResponseDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
